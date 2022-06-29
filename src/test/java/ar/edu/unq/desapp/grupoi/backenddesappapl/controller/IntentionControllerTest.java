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
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;

@SpringBootTest(classes = ar.edu.unq.desapp.grupoi.backenddesappapl.SwaggerApiApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class IntentionControllerTest { 
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void registerOk() throws Exception {
		RegisterUserDTO userDTO =  new RegisterUserDTO("nameTestB", "surnameTestB", "nacho@gmail.com", "addressTestB", "123Test#B");
		
		this.mockMvc.perform(post("/user/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(userDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		RegisterIntentionDTO intentionDTO =  new RegisterIntentionDTO("MATICUSDT","2,3","15,0","nacho@gmail.com","SELL");
		
		this.mockMvc.perform(post("/intention/register")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(intentionDTO.toString())
	            .accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk());
	}
	
	@Test
	public void registerError() throws Exception {
		RegisterIntentionDTO intentionDTO =  new RegisterIntentionDTO("MATICUSDT","5","10","inexistente@gmail.com","SELL");
		
		this.mockMvc.perform(post("/intention/register")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(intentionDTO.toString())
	            .accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isBadRequest());
	}
	
	@Test
    public void findAll() throws Exception {
    	this.mockMvc.perform(get("/intention/getAll")
    		.contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
    }
}
