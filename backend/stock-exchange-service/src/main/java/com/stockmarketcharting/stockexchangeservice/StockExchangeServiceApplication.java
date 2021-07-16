package com.stockmarketcharting.stockexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.stockmarketcharting.stockexchangeservice.repository")
public class StockExchangeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockExchangeServiceApplication.class, args);
    }

}
