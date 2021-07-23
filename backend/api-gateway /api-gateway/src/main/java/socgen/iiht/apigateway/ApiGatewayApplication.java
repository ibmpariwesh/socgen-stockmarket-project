package socgen.iiht.apigateway;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.resource.HttpResource;
import reactor.core.publisher.Mono;
import socgen.iiht.apigateway.util.JwtUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@SpringBootApplication
@EnableEurekaClient
@EnableWebFluxSecurity
public class ApiGatewayApplication {
	@Autowired
	private WebClient.Builder webClientBuilder;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	@Autowired
	JwtUtil jwtUtil;

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http){
		http
				.authorizeExchange()
				.pathMatchers("/**").permitAll();
//				.hasAuthority("ROLE_ADMIN");
//				.and().httpBasic();
//				.anyExchange().authenticated();
		return http.build();
	}


	@Bean
	public GlobalFilter globalFilter(){
		return((exchange, chain) -> {
			System.out.println("first filter");
			String str=exchange.getRequest().getHeaders().get("Authorization").get(0);
			String jwt=str.substring(7);
			exchange.getRequest().mutate()
					.header("Authorization","Bearer "+jwt);
			try{
				boolean isKeyValid = webClientBuilder.build()
						.post()
						.uri(new URI("http://localhost:7000/validate_jwt"))
						.header("jwtToken",jwt)
						.retrieve()
						.bodyToMono(boolean.class)
						.toProcessor().block(Duration.ofMillis(500));

			} catch (URISyntaxException e) {

				exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
				return chain.filter(exchange).then(Mono.fromRunnable(()-> System.out.println("errrorrr!")));

			}

			return  chain.filter(exchange).then(Mono.fromRunnable(()->{
				System.out.println("second Filter");
			}));
		});
	}

}
