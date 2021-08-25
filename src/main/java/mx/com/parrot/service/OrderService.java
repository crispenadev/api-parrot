package mx.com.parrot.service;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.parrot.controller.OrderRequest;
import mx.com.parrot.entity.Order;
import mx.com.parrot.entity.User;
import mx.com.parrot.exception.DataNotFoundException;
import mx.com.parrot.repository.OrderRepository;
import mx.com.parrot.repository.UserRepository;

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
	
	
	@Autowired
	private UserRepository userRepository;

	public Order save(final OrderRequest orderRequest) throws RemoteException {

	
		LOGGER.info("Init service save order");
		
		
		User user = userRepository.findByEmail(orderRequest.getUserEmail());
		
		
		if(user==null) {
			throw new DataNotFoundException(orderRequest.getUserEmail());
			
		}
		
		return orderRepository.insert(createOrder(orderRequest));
		
		
	}

	
	
	public Order createOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setCustomer(orderRequest.getCustomer());
		order.setPrice(orderRequest.getPrice());
		order.setCdate(new Date());
		order.setUserEmail(orderRequest.getUserEmail());
		order.setProducts(orderRequest.getProducts());
		return order;
		
	}
}
