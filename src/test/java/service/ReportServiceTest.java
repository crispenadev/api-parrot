package service;

import static org.assertj.core.api.Assertions.assertThat;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import mx.com.parrot.ConfigApplication;
import mx.com.parrot.entity.Order;
import mx.com.parrot.entity.Product;
import mx.com.parrot.service.ReportService;


@SpringBootTest(classes = ConfigApplication.class)

public class ReportServiceTest {

	
	@InjectMocks
	private ReportService reportService;
	

	

	@Test
	public void createMapProductNameTest() throws RemoteException {
		
		Order order = new Order();
		order.setCustomer("customerTestt");
		order.setPrice(52.0);
		
		List<Product> products = new ArrayList<>();
		Product product = new Product();
		product.setCantidad(9);
		product.setUnitPrice(8.0);
		product.setName("Pizza");
		products.add(product);
		order.setProducts(products);
		List<Order> orders = new ArrayList<Order>();
		
		
		orders.add(order);
		HashMap<String, List<Product>> map = reportService.createMapProductName(orders) ;
		assertThat(map).isNotNull();
	}
}
