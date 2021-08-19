package mx.com.parrot.entity;

import java.util.Date;
import java.util.HashSet;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "os.order")
public class Order {

	
	
	
private String customer;
	


	private Double price;
	
	
	private Date cdate;
	
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


	public Date getCdate() {
		return cdate;
	}


	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}


	


}
