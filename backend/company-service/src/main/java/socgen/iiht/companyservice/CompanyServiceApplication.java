package socgen.iiht.companyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import socgen.iiht.companyservice.model.Company;
import socgen.iiht.companyservice.repository.CompanyRepo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class CompanyServiceApplication implements CommandLineRunner {
	@Autowired
	private CompanyRepo companyRepo;

	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}

	@Configuration
	public class MyConfiguration implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedMethods("*");
		}

	}

	@Override
	public void run(String... args) throws Exception {
		Company company1=new Company("Apple","Tim Cook","Fortune 1","AAPL","https://www.freepnglogos.com/uploads/apple-logo-png/file-apple-logo-black-svg-wikimedia-commons-1.png");
		Company company2=new Company("Google","Sundar Pichai","free services 4 all","GOOGL","https://www.freepnglogos.com/uploads/new-google-logo-transparent--14.png");
		Company company3=new Company("Twitter","Jack Dorsey","a new democracy","TWTR","https://www.freepnglogos.com/uploads/twitter-logo-png/twitter-logo-vector-png-clipart-1.png");
		Company company4=new Company("Reliance","Mukesh Ambani","indian conglomerate","RIL","https://logodownload.org/wp-content/uploads/2019/10/reliance-industries-logo-0.png");

		companyRepo.save(company1);
		companyRepo.save(company2);
		companyRepo.save(company3);
		companyRepo.save(company4);


	}
}
