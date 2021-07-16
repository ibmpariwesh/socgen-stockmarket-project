package com.sgTrain.stockexchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgTrain.stockexchange.entities.StockEx;
import com.sgTrain.stockexchange.services.StockExService;

@RestController
@RequestMapping("/stock")
public class StockExController {
	
	@Autowired
	StockExService exService;
	
	@GetMapping("/get")
	public List<StockEx> getExchange(StockEx ex) {
		return exService.getStockEx() ;
	}
	
	@PostMapping("/save")
	public boolean createExchange(@RequestBody StockEx ex) {
		return exService.createStockEx(ex);
	}
	
	@DeleteMapping("{id}")
	public boolean deleteExchange(@PathVariable String id) throws Exception{
		return exService.deleteStock(id);
	}

}
