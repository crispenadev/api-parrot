package mx.com.parrot.controller;

import java.rmi.RemoteException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mx.com.parrot.entity.Order;
import mx.com.parrot.service.OrderService;

@RestController
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);


	@Autowired
	private OrderService orderService;

	
	@Operation(summary = "Save order with your list products")
	@ApiResponse(responseCode = "200", description = "Success Response", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) })
	@PostMapping("api-parrot/order/save")
	public Order saveOrder(@RequestBody OrderRequest request) throws RemoteException {
		log.info("Request: "+request);
		return orderService.save(request);
	}

}
