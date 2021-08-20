package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mx.com.parrot.ConfigApplication;
import mx.com.parrot.controller.PrincipalController;

@SpringBootTest(classes = ConfigApplication.class)
@AutoConfigureMockMvc
public class PrincipalControllerTest {

	private MockMvc mockMvc;



	@Test
	public void testLogin() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(new PrincipalController()).build();

		this.mockMvc.perform(post("/api-parrot/principal/login").param("username", "crs").param("pwd", "hasttest"))
				.andExpect(status().isOk());
	}


}
