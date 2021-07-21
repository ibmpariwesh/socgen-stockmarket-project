package socgen.iiht.stockexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import socgen.iiht.stockexchangeservice.model.Address;
import socgen.iiht.stockexchangeservice.model.StockExchange;
import socgen.iiht.stockexchangeservice.repository.StockExchangeRepo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient

public class StockExchangeServiceApplication implements CommandLineRunner {
	@Autowired
	private StockExchangeRepo stockExchangeRepo;

	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(StockExchangeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("abs street","Albuquerque","America","36910");
		StockExchange stockExchange=new StockExchange("MS4X","Miami Stock Exchange",address,"based in miami");
		stockExchangeRepo.save(stockExchange);
	}
}
