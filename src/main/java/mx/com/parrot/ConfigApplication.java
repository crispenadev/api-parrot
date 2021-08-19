package mx.com.parrot;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api-parrot/report").permitAll()
				.antMatchers(HttpMethod.POST, "/api-parrot/user/login").permitAll()
				 .antMatchers(
		                    HttpMethod.GET,
		                    "/v3/api-docs",           // swagger
		                    "/webjars/**",            // swagger-ui webjars
		                    "/swagger-resources/**",  // swagger-ui resources
		                    "/configuration/**",      // swagger configuration
		                    "/*.html",
		                    "/favicon.ico",
		                    "/**/*.html",
		                    "/**/*.css",
		                    "/**/*.js"
		            ).permitAll()
				.anyRequest().authenticated();
		}
	}


}
