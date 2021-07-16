package com.sgtrain.stockexchange.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgtrain.stockexchange.entities.StockEx;
import com.sgtrain.stockexchange.entities.StockExRepository;
import com.sgtrain.stockexchange.entities.model.AddressRepository;
import com.sgtrain.stockexchange.entities.model.StockExAddress;

@Component
public class StockExService {

	@Autowired
	StockExRepository exRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public List<StockEx> getStockEx(){
		return exRepository.findAll();
	}
	
	public boolean createStockEx(StockEx ex) {
		exRepository.save(ex);
		return true;
	}
	

}
