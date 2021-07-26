package socgen.iiht.stockexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;
import socgen.iiht.stockexchangeservice.model.Address;
import socgen.iiht.stockexchangeservice.model.StockExchange;
import socgen.iiht.stockexchangeservice.repository.StockExchangeRepo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@CrossOrigin
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
//		Address address = new Address("abs street","Albuquerque","America","236910");
//		Address address1 = new Address("xfe street","Vicecity","America","138410");
//		Address address2 = new Address("abs street","SanAndreas","India","939910");
//		Address address3 = new Address("abs street","Vegeta","Japan","354610");
//
//		StockExchange stockExchange=new StockExchange("MS4X","Miami Stock Exchange",address,"based in miami");
//		StockExchange stockExchange1=new StockExchange("NSE","Neywork Stock Exchange",address1,"based in newyork");
//		StockExchange stockExchange2=new StockExchange("BSE","Bombay Stock Exchange",address2,"based in mumbai");
//		StockExchange stockExchange3=new StockExchange("TYO","Tokyo Stock Exchange",address3,"based in Japan");
//
//		stockExchangeRepo.save(stockExchange);
//		stockExchangeRepo.save(stockExchange1);
//		stockExchangeRepo.save(stockExchange2);
//		stockExchangeRepo.save(stockExchange3);
	}
}
