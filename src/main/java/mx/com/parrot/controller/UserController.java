package mx.com.parrot.controller;

import java.rmi.RemoteException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mx.com.parrot.entity.Product;
import mx.com.parrot.entity.User;
import mx.com.parrot.service.UserService;

@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	


	@Operation(summary = "Save user email and name")
	@ApiResponse(responseCode = "200", description = "Success Response", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserRequest.class)) })
	@PostMapping(value = "/api-parrot/user", consumes = "application/json", produces = "application/json")
	public User saveUser(@RequestBody UserRequest request) throws RemoteException {
		log.info("Paylod in  saveUser : "+ request);
		return userService.save(request);
		
	}
	
	
	@Operation(summary = "Get user by email")
	@ApiResponse(responseCode = "200", description = "Success Response", content = {
			@Content(mediaType = "application/json") })
	@GetMapping(value = "/api-parrot/users/{emailUser}", consumes = "application/json", produces = "application/json")
	public User getUser(@PathVariable String emailUser) throws RemoteException {
		log.info("Paylod in  getUser : "+ emailUser);
		return userService.findByEmail(emailUser);
	}


	
	@Operation(summary = "Get all users")
	@ApiResponse(responseCode = "200", description = "Success Response", content = {
			@Content(mediaType = "application/json") })
	@GetMapping(value = "/api-parrot/users", produces = "application/json")
	public List<User> getUsers() throws RemoteException {
	
		return userService.findAll();
	}



}



