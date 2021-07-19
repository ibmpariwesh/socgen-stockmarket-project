package com.pavan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.entity.StockExchange;
import com.pavan.service.StockExchangeService;

@RestController
public class StockExchangeController {
	
	@Autowired
	private StockExchangeService stockExchangeService;
	
	@GetMapping("")
	public String list() {
		return "Hello there";
	}
	
	@GetMapping("/stocks")
	public ResponseEntity<List<StockExchange>> getStockExchanges(){
		
		return ResponseEntity.ok(stockExchangeService.getAllStockExchanges());
		
	}
	
	@PostMapping("/stocks")
	public ResponseEntity<StockExchange> addStockExchanges(@RequestBody StockExchange stockExchange){
		return ResponseEntity.ok(stockExchangeService.addStockExchanges(stockExchange));
		
	}
	
	@GetMapping("/stocks/{id}")
	public ResponseEntity getOneStockExchange(@PathVariable int id) {
		StockExchange exchange  = stockExchangeService.getOneStockExchange(id);
		if(exchange == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Stock Exchange found for the given Id");
		}
		return ResponseEntity.ok(exchange);
	}
	

}
