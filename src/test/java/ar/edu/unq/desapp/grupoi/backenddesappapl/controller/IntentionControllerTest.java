package ar.edu.unq.desapp.grupoi.backenddesappapl.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;

@SpringBootTest(classes = ar.edu.unq.desapp.grupoi.backenddesappapl.SwaggerApiApplication.class)
@AutoConfigureMockMvc
public class IntentionControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void registerOk() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		RegisterIntentionDTO intentionDTO =  new RegisterIntentionDTO("MATICUSDT","2,3","15,0","nacho@gmail.com","SELL");
		
		this.mockMvc.perform(post("/transaction/intention/register")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(intentionDTO))
	            .accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk());
	}
	
	@Test
	public void registerError() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		RegisterIntentionDTO intentionDTO =  new RegisterIntentionDTO("MATICUSDT","5","10","inexistente@gmail.com","SELL");
		
		this.mockMvc.perform(post("/transaction/intention/register")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(intentionDTO))
	            .accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isBadRequest());
	}
	
	
	@Test
    public void findAll() throws Exception {
    	this.mockMvc.perform(get("/transaction/intention/getAll")
    		.contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
    }
		

}
