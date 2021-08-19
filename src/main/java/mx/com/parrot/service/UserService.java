package mx.com.parrot.service;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.parrot.controller.UserRequest;
import mx.com.parrot.entity.User;
import mx.com.parrot.exception.DataNotFoundException;
import mx.com.parrot.repository.UserRepository;

/**
 * Servicio que provee una interfaz para la invocacion de Web Service SOAP de
 * FileNet
 * 
 * @author Cristian
 *
 */
@Service
public class UserService {

	private static final Log LOGGER = LogFactory.getLog(UserService.class);

	@Autowired
	private UserRepository userRepository;

	
	public User save(final UserRequest request) throws RemoteException {

		User user = new User();

		user.setName(request.getName());
		user.setEmail(request.getEmail());

		return userRepository.insert(user);
	}

	
	
	public User findByEmail(final String email) throws RemoteException {
	User cf = userRepository.findByEmail(email);

	if (cf == null) {
		throw new DataNotFoundException(email);
	}

	return cf;
	}

}
