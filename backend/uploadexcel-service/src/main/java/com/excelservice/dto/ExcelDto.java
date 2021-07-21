package com.excelservice.dto;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;

public class ExcelDto {
	private int companyId;
	
	private int exchangeId;
	
	private double price;
	
	//private Timestamp timestamp;
	private Date date;
	private Time time;
	
	public ExcelDto() {
		super();
	}
	public ExcelDto(int companyId, int exchangeId, double price, Date date, Time time) {
		super();
		this.companyId = companyId;
		this.exchangeId = exchangeId;
		this.price = price;
		this.date = date;
		this.time = time;
	}
public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	/*
	public ExcelDto(int companyId, int exchangeId, double price, Timestamp timestamp) {
		super();
		this.companyId = companyId;
		this.exchangeId = exchangeId;
		this.price = price;
		this.timestamp = timestamp;
	}
*/
	public int getCompanyId() {
		return companyId;
	}

	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
/*
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
*/
}
