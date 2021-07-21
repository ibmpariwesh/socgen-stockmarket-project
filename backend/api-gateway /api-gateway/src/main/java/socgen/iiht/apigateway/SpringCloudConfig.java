package socgen.iiht.apigateway;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Bean
    @LoadBalanced
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("company-service",(r)->r.path("/company/**")

                        .uri("lb://COMPANY-SERVICE"))
                .route(r->r.path("/stock_exchange/**")
                .uri("lb://STOCK-EXCHANGE-SERVICE"))
                .build();

    }
}
