package com.koderunner.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	@Column
	private String productName;
	
	@Column
	private double price;
	
	@Column
	private String description;
	
	public Product(){	}
	

	public Product(int productId, String productName, double price, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
