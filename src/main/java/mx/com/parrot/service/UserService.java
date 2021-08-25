package mx.com.parrot.service;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.parrot.controller.UserRequest;
import mx.com.parrot.entity.Product;
import mx.com.parrot.entity.User;
import mx.com.parrot.exception.DataNotFoundException;
import mx.com.parrot.repository.UserRepository;

/**
 * Servicio para la lógica de negocio dedicada a las operaciones de creacion y consulta de un usuario
 * 
 * @author Cristian Ivan Peña
 *
 */
@Service
public class UserService {

	private static final Log LOGGER = LogFactory.getLog(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public User save(final UserRequest request) throws RemoteException {
		LOGGER.info("Init service save user");
		return userRepository.insert(getUserEntity(request));
	}

	private User getUserEntity(UserRequest request) {
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setCdate(new Date());
		return user;
	}

	
	
	public User findByEmail(final String email) throws RemoteException {
		
		LOGGER.info("Init service find user");
		User cf = userRepository.findByEmail(email);

		if (cf == null) {
			throw new DataNotFoundException(email);
		}

		return cf;
	}

	public List<User> findAll() {
		return userRepository.findAll();
		
	}

}
