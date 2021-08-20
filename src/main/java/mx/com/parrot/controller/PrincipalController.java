package mx.com.parrot.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mx.com.parrot.entity.Principal;


/**
 * Controler para el acceso de peticion de TOKEN JWT
 * 
 * @author Cristian Ivan Peña
 *
 */
@RestController
public class PrincipalController {


	
	
	@Operation(summary = "Get token jwt")
	@PostMapping("/api-parrot/principal/login")
	@ApiResponse(responseCode = "200", description = "Success Response", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Principal.class)) })
	public Principal login(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
		
		String token = getJWTToken(username);
		Principal principal = new Principal();
		principal.setUser(username);
		principal.setToken(token);
		principal.setPwd("not available");
		principal.setCdate(new Date());
		principal.setToken(token);
		return principal;
		
	}




	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("parrotIDJWT")
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



