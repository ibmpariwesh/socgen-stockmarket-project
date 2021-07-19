package com.pavan.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STOCK_EXCHANGE")
public class StockExchange {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BREIF")
	private String breif;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@OneToOne(cascade=CascadeType.ALL)
    private Address address;

	public StockExchange() {
		super();
	}

	public StockExchange(int id, String name, String breif, String remarks, Address addressId) {
		super();
		this.id = id;
		this.name = name;
		this.breif = breif;
		this.remarks = remarks;
		this.address = addressId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreif() {
		return breif;
	}

	public void setBreif(String breif) {
		this.breif = breif;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
