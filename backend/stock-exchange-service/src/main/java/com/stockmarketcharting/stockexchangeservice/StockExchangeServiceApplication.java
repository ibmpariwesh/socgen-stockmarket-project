package com.stockmarketcharting.stockexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StockExchangeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockExchangeServiceApplication.class, args);
    }

}
