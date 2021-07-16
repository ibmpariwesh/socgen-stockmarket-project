package com.stockmarketcharting.stockexchangeservice.controller;


import com.stockmarketcharting.stockexchangeservice.entity.StockExchange;
import com.stockmarketcharting.stockexchangeservice.service.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/stockExchange")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;

    @PostMapping("/addStockExchange")
    public StockExchange addStockExchange(@RequestBody StockExchange stockExchange) {
        return stockExchangeService.addStockExchange(stockExchange);
    }

    @GetMapping("/getAllExchanges")
    public List<StockExchange> getAllExchanges() {
        return stockExchangeService.getAllExchanges();
    }


    @GetMapping("/getStockExchange/{id}")
    public Optional<StockExchange> getStockExchangeById(@PathVariable Integer id) {
        return stockExchangeService.getStockExchangeById(id);
    }

    @GetMapping("/getStockExchange/{name}")
    public StockExchange getStockExchangeByName(@PathVariable String name) {
        return stockExchangeService.getStockExchangeByName(name);
    }

}
