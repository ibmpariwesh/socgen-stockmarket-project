package com.ud.stockexchangeservice.controllers;


import com.ud.stockexchangeservice.Entities.StockExchange;
import com.un.stockexchangeservice.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/stockExchange")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;

    @GetMapping
    public String controllerCheck() {
        return "This controller is functional!!";
    }

    @PostMapping
    public StockExchange addStockExchange(StockExchange stockExchange) {
        return stockExchangeService.addStockExchange(stockExchangeEntity);
    }
}
