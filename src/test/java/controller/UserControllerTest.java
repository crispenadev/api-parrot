package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mx.com.parrot.ConfigApplication;
import mx.com.parrot.controller.UserController;

@SpringBootTest(classes = ConfigApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	private MockMvc mockMvc;





	@Test
	public void testDocumentById() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

		this.mockMvc.perform(
				post("/api-parrot/user").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());

	}


}
