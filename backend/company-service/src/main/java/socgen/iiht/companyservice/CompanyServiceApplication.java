package socgen.iiht.companyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import socgen.iiht.companyservice.model.Company;
import socgen.iiht.companyservice.repository.CompanyRepo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CompanyServiceApplication implements CommandLineRunner {
	@Autowired
	private CompanyRepo companyRepo;

	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Company company1=new Company("Apple","Tim Cook","Fortune 1","AAPL");
		Company company2=new Company("Google","Sundar","free services 4 all","GOOGL");
		companyRepo.save(company1);
		companyRepo.save(company2);
	}
}
