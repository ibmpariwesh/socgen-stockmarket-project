package com.ud.stockexchangeservice.controllers;


import com.ud.stockexchangeservice.entities.StockExchange;
import com.ud.stockexchangeservice.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/stockExchange")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;

    @GetMapping
    public List<StockExchange> getStockExchangeList() {
        return stockExchangeService.getStockExchangeList();
    }

    @PostMapping
    public StockExchange addStockExchange(@RequestBody StockExchange stockExchange) {
        return stockExchangeService.addStockExchange(stockExchange);
    }
}
