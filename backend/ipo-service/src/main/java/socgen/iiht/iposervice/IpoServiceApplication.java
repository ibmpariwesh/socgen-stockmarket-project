package socgen.iiht.iposervice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import socgen.iiht.iposervice.model.Ipo;
import socgen.iiht.iposervice.repository.IpoRepo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class IpoServiceApplication implements CommandLineRunner {
	@Autowired
	private IpoRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(IpoServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ipo ipo=new Ipo(997.13f,41, LocalDateTime.now(),"first public offering");
		Ipo ipo1=new Ipo(167.245f,145, LocalDateTime.now(),"open public offering");
		Ipo ipo2=new Ipo(859.12f,14, LocalDateTime.now(),"shares public offering");
		Ipo ipo3=new Ipo(258.2f,185, LocalDateTime.now(),"test1 public offering");
		Ipo ipo4=new Ipo(953.12f,54, LocalDateTime.now(),"test2 public offering");
		Ipo ipo5=new Ipo(112.69f,58, LocalDateTime.now(),"test3 public offering");

		repo.save(ipo);
		repo.save(ipo1);
		repo.save(ipo2);
		repo.save(ipo3);
		repo.save(ipo4);
		repo.save(ipo5);
	}
}
