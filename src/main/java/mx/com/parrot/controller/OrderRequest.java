package mx.com.parrot.controller;

import java.util.List;

import mx.com.parrot.entity.Product;
/**
 * Clase dedicada al modelo del request de una Orden
 * 
 * @author Cristian Ivan Peña
 *
 */
public class OrderRequest extends GeneralRequest {

	private String customer;
	
	private String userEmail;
	
	private Double price;

	private List<Product> products;

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



}
