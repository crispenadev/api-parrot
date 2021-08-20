package service;

import static org.assertj.core.api.Assertions.assertThat;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import mx.com.parrot.ConfigApplication;
import mx.com.parrot.controller.OrderRequest;
import mx.com.parrot.entity.Order;
import mx.com.parrot.entity.Product;
import mx.com.parrot.service.OrderService;


@SpringBootTest(classes = ConfigApplication.class)

public class OrderServiceTest {

	
	@InjectMocks
	private OrderService orderService;
	

	

	@Test
	public void testCreateOrder() throws RemoteException {
		
		
		OrderRequest request = new OrderRequest();
		request.setCustomer("customerTestt");
		request.setPrice(52.0);
		
		List<Product> products = new ArrayList<>();
		Product product = new Product();
		product.setCantidad(9);
		product.setUnitPrice(8.0);
		product.setName("Pizza");
		products.add(product);
		request.setProducts(products);
		
		Order order =orderService.createOrder(request );
		assertThat(order).isNotNull();
		

	}
}
