package mx.com.parrot.entity;

public class ResponseProduct {

	
	private String nameProduct;
	
	
	
	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}


	public Long getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(Long countTotal) {
		this.countTotal = countTotal;
	}


	public Double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}


	private Long countTotal;
	
	private Double priceTotal;


}
