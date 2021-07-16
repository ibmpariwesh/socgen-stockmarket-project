package com.sgTrain.stockexchange.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class StockEx {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String exchangeName;
	private String brief;
	private String remarks;
	private String exhID;
	
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

}
