package mx.com.parrot.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.parrot.controller.OrderRequest;
import mx.com.parrot.entity.Order;
import mx.com.parrot.entity.Product;
import mx.com.parrot.repository.OrderRepository;

/**
 * Servicio que provee una interfaz para la invocacion de Web Service SOAP de
 * FileNet
 * 
 * @author Cristian
 *
 */
@Service
public class OrderService {

	private static final Log LOGGER = LogFactory.getLog(OrderService.class);

	@Autowired
	private OrderRepository orderRepository;

	public Order save(final OrderRequest orderRequest) throws RemoteException {

		Order order = new Order();
		order.setCustomer(orderRequest.getCustomer());
		order.setPrice(orderRequest.getPrice());

		HashMap<String, List<Product>> hashMap = new HashMap<>();

		for (Product p : orderRequest.getProducts()) {
			if (!hashMap.containsKey(p.getName())) {
				List<Product> list = new ArrayList<>();
				list.add(p);

				hashMap.put(p.getName(), list);
			} else {
				hashMap.get(p.getName()).add(p);
			}
		}
		
		
		order.setCdate(new Date());

	

		order.setProducts(orderRequest.getProducts());

		return orderRepository.insert(order);
	}

}
