package com.sgTrain.stockexchange.entities.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sgTrain.stockexchange.entities.StockEx;

@Entity
@Table(name="address")
public class StockExAddress {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id")
	private int id;
	private int houseNo;
	private String city;
	private int pin;
	private String state;

	public StockExAddress() {
		
	}
	
	public StockExAddress(int id, int houseNo, String city, int pin, String state, StockEx stockex) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.city = city;
		this.pin = pin;
		this.state = state;
		
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
