package com.sgTrain.stockexchange.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sgTrain.stockexchange.entities.model.StockExAddress;


@Entity
@Table(name="stockex")
public class StockEx {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id")
	private int id;
	private String exchangeName;
	private String brief;
	private String remarks;
	private String exgId;

	@OneToOne(cascade = CascadeType.ALL)
	private StockExAddress stockExAddress;

	public StockEx() {
		
	}
	
	
	public StockEx(int id, String exchangeName, String brief, String remarks, String exgId,
			StockExAddress stockExAddress) {
		super();
		this.id = id;
		this.exchangeName = exchangeName;
		this.brief = brief;
		this.remarks = remarks;
		this.exgId = exgId;
		this.stockExAddress = stockExAddress;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getExgId() {
		return exgId;
	}
	public void setExgId(String exgId) {
		this.exgId = exgId;
	}
	public StockExAddress getStockExAddress() {
		return stockExAddress;
	}


	public void setStockExAddress(StockExAddress stockExAddress) {
		this.stockExAddress = stockExAddress;
	}
	
}
