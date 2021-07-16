package com.stockmarketcharting.stockexchangeservice.service;

import com.stockmarketcharting.stockexchangeservice.entity.StockExchange;
import com.stockmarketcharting.stockexchangeservice.repository.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    public StockExchange addStockExchange(StockExchange stockExchange) {

        if (stockExchange != null) {
            return stockExchangeRepository.save(stockExchange);
        }
        return null;
    }

    public List<StockExchange> getAllExchanges() {
        return stockExchangeRepository.findAll();
    }

    public Optional<StockExchange> getStockExchangeById(Integer stockExchangeId) {
        if (stockExchangeId != null) {
            return stockExchangeRepository.findById(stockExchangeId);
        }
        return null;
    }

    public StockExchange getStockExchangeByName(String stockExchangeName) {
        if (stockExchangeName != null) {
            return stockExchangeRepository.findByName(stockExchangeName);
        }
        return null;
    }


}
