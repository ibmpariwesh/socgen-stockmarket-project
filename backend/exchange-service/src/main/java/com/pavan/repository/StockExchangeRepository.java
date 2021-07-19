package com.pavan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.entity.StockExchange;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer>{
	
	

}
