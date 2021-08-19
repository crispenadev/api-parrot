package mx.com.parrot.controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mx.com.parrot.entity.User;
import mx.com.parrot.service.UserService;

@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;


	
	@Operation(summary = "Get user by email")
	@ApiResponse(responseCode = "200", description = "Success Response", content = {
			@Content(mediaType = "application/json") })
	@GetMapping(value = "api-parrot/users/{emailUser}", consumes = "application/json", produces = "application/json")
	public User getUser(@PathVariable String emailUser) throws RemoteException {
		log.info("Email"+ emailUser);
		return userService.findByEmail(emailUser);
	}

	@Operation(summary = "Save user email and name")
	@ApiResponse(responseCode = "200", description = "Success Response", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserRequest.class)) })
	@PostMapping(value = "api-parrot/user", consumes = "application/json", produces = "application/json")
	public User saveUser(@RequestBody UserRequest request) throws RemoteException {
		return userService.save(request);
	}
	
	@Operation(summary = "Get token jwt")
	@PostMapping("api-parrot/user/login")
	public User login(@RequestParam("username") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}



