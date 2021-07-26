package socgen.iiht.relationshipservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import socgen.iiht.relationshipservice.model.CompanyToStockExchange;
import socgen.iiht.relationshipservice.repository.CompanyToStockExchangeRepo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class RelationshipServiceApplication implements CommandLineRunner {
	@Autowired
	private CompanyToStockExchangeRepo ctsRepo;
	public static void main(String[] args) {
		SpringApplication.run(RelationshipServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CompanyToStockExchange cts1= new CompanyToStockExchange(1,3);
		CompanyToStockExchange cts2= new CompanyToStockExchange(1,5);
		CompanyToStockExchange cts3= new CompanyToStockExchange(2,3);
		CompanyToStockExchange cts4= new CompanyToStockExchange(2,1);
		CompanyToStockExchange cts5= new CompanyToStockExchange(2,7);
		CompanyToStockExchange cts6= new CompanyToStockExchange(3,1);
		CompanyToStockExchange cts7= new CompanyToStockExchange(4,5);
		CompanyToStockExchange cts8= new CompanyToStockExchange(4,3);
		ctsRepo.save(cts1);
		ctsRepo.save(cts2);
		ctsRepo.save(cts3);
		ctsRepo.save(cts4);
		ctsRepo.save(cts5);
		ctsRepo.save(cts6);
		ctsRepo.save(cts7);
		ctsRepo.save(cts8);

	}
}
