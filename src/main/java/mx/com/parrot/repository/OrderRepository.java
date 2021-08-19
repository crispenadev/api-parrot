package mx.com.parrot.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.com.parrot.entity.Order;



@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
	
	List<Order> findByCdateBetween(Date cdate,Date cdateEnd);
}
