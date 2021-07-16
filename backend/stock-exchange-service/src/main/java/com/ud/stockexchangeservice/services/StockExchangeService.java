package com.ud.stockexchangeservice.services;

import com.ud.stockexchangeservice.entities.StockExchange;
import com.ud.stockexchangeservice.repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    public StockExchange addStockExchange(StockExchange stockExchange) {
        return this.stockExchangeRepository.save(stockExchange);
    }
}
