package com.stockmarketcharting.stockexchangeservice.repository;

import com.stockmarketcharting.stockexchangeservice.entity.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer> {
    StockExchange findByName(String stockExchangeName);
}
