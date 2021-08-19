package mx.com.parrot.controller;

import java.util.HashSet;

import mx.com.parrot.entity.Product;

public class OrderRequest extends GeneralRequest {

	private String customer;
	
	private Double price;

	private HashSet<Product> products;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public HashSet<Product> getProducts() {
		return products;
	}

	public void setProducts(HashSet<Product> products) {
		this.products = products;
	}
}
