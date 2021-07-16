package com.ud.stockexchangeservice.controllers;


import com.ud.stockexchangeservice.entities.StockExchange;
import com.ud.stockexchangeservice.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public StockExchange addStockExchange(@RequestBody StockExchange stockExchange) {
        return stockExchangeService.addStockExchange(stockExchange);
    }
}
