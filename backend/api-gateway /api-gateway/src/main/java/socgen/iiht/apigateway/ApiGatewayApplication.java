package socgen.iiht.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public GlobalFilter globalFilter(){
		return((exchange, chain) -> {
			System.out.println("first filter");

//			exchange.getRequest().
//					mutate()
//					.header("Authentication","Bearer ")
//					.build();

			return  chain.filter(exchange).then(Mono.fromRunnable(()->{
				System.out.println("second Filter");
			}));
		});
	}

}
