package com.sgTrain.stockexchange.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgTrain.stockexchange.entities.StockEx;
import com.sgTrain.stockexchange.entities.StockExRepository;

@Component
public class StockExService {

	@Autowired
	StockExRepository exRepository;
	
	public List<StockEx> getStockEx(){
		return exRepository.findAll();
	}
	
	public boolean createStockEx(StockEx ex) {
		exRepository.save(ex);
		return true;
	}
	
	public boolean deleteStock(String id) throws Exception{
		exRepository.deleteById(id);
		return true;
	}

}
