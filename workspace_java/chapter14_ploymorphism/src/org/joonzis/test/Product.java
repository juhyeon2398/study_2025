package org.joonzis.test;

public class Product {
	private String model; 
	private int price;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Product() {
	}
	
	public Product(String model, int price) {
		setModel(model);
		setPrice(price);
	}
	
}
