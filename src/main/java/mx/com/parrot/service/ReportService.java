package mx.com.parrot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.parrot.controller.ReportRequest;
import mx.com.parrot.entity.Order;
import mx.com.parrot.entity.Product;
import mx.com.parrot.entity.Report;
import mx.com.parrot.entity.ResponseProduct;
import mx.com.parrot.repository.OrderRepository;

/**
 * Servicio que provee una interfaz para la invocacion de Web Service SOAP de
 * FileNet
 * 
 * @author Cristian
 *
 */
@Service
public class ReportService {

	private static final Log LOGGER = LogFactory.getLog(ReportService.class);

	@Autowired
	private OrderRepository orderRepository;

	public Report getReport(ReportRequest request) {

		LOGGER.info(request.getInitDate() + "end" + request.getEndDate());
		Report report = new Report();
		List<Order> orders = orderRepository.findByCdateBetween(request.getInitDate(), request.getEndDate());
		HashMap<String, List<Product>> mapProductByName = createMapProductName( orders);

		report.setListProductReport(getResponseProduct(mapProductByName));
		return report;
	}

	public HashMap<String, List<Product>> createMapProductName(List<Order> orders ) {

		List<Product> products = new ArrayList<>();

		

		for (Order order : orders) {

			products.addAll(order.getProducts());
		}
		HashMap<String, List<Product>> mapProductByName = new HashMap<>();

		for (Product p : products) {
			if (!mapProductByName.containsKey(p.getName())) {
				List<Product> list = new ArrayList<>();
				list.add(p);

				mapProductByName.put(p.getName(), list);
			} else {
				mapProductByName.get(p.getName()).add(p);
			}
		}

		return mapProductByName;

	}

	private List<ResponseProduct> getResponseProduct(HashMap<String, List<Product>> mapProductByName) {
		List<ResponseProduct> responseProduct = new ArrayList<>();
		for (Map.Entry<String, List<Product>> entry : mapProductByName.entrySet()) {
			LOGGER.info("Key = " + entry.getKey() + ", Value = " + entry.getValue());

			Long totalCount = 0L;
			Double totalPrice = 0.0;
			for (Product product : entry.getValue()) {

				totalCount = totalCount + product.getCantidad();
				totalPrice = totalPrice + product.getUnitPrice() * product.getCantidad();

			}
			ResponseProduct rep = new ResponseProduct();
			rep.setCountTotal(totalCount);
			rep.setPriceTotal(totalPrice);
			rep.setNameProduct(entry.getKey());
			responseProduct.add(rep);
		}
		return responseProduct;
	}

}
