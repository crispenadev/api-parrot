package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mx.com.parrot.ConfigApplication;
import mx.com.parrot.controller.ReportController;



@SpringBootTest(classes = ConfigApplication.class)
@AutoConfigureMockMvc
public class ReportControllerTest {

	private MockMvc mockMvc;



	@Test
	public void testDocumentById() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(new ReportController()).build();

		


		this.mockMvc.perform(get("/api-parrot/report").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());

	}

	
}
