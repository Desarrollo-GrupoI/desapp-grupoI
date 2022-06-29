package ar.edu.unq.desapp.grupoi.backenddesappapl.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterTransactionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.TransactionActionDTO;

@SpringBootTest(classes = ar.edu.unq.desapp.grupoi.backenddesappapl.SwaggerApiApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class TransactionControllerTest {
	
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
		
		RegisterUserDTO userTwo =  new RegisterUserDTO("nameTestB", "surnameTestB", "otroMail@gmail.com", "addressTestB", "123Test#B");	
		this.mockMvc.perform(post("/user/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(userTwo.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		RegisterIntentionDTO intentionDTO =  new RegisterIntentionDTO("MATICUSDT","2,3","15,0",userDTO.getEmail(),"SELL");		
		this.mockMvc.perform(post("/intention/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(intentionDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
				
		RegisterTransactionDTO transactionDTO =  new RegisterTransactionDTO(1, userTwo.getEmail());
		this.mockMvc.perform(post("/transaction/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(transactionDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
	}
	 
	
	@Test
	public void registerError() throws Exception {
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
		
		
		RegisterTransactionDTO transactionDTO =  new RegisterTransactionDTO(1, "inexistente@gmail.com");
		this.mockMvc.perform(post("/transaction/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(transactionDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isBadRequest());
	}
	
	@Test
	public void acceptOk() throws Exception {
		RegisterUserDTO userDTO =  new RegisterUserDTO("nameTestB", "surnameTestB", "nacho@gmail.com", "addressTestB", "123Test#B");	
		this.mockMvc.perform(post("/user/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(userDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		RegisterUserDTO userTwo =  new RegisterUserDTO("nameTestB", "surnameTestB", "otroMail@gmail.com", "addressTestB", "123Test#B");	
		this.mockMvc.perform(post("/user/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(userTwo.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		RegisterIntentionDTO intentionDTO =  new RegisterIntentionDTO("MATICUSDT","2,3","4,0",userDTO.getEmail(),"SELL");		
		this.mockMvc.perform(post("/intention/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(intentionDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
			
		RegisterTransactionDTO transactionDTO =  new RegisterTransactionDTO(1, userTwo.getEmail());
		this.mockMvc.perform(post("/transaction/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(transactionDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		TransactionActionDTO acceptTransaction = new TransactionActionDTO(1,userDTO.getEmail());
		this.mockMvc.perform(post("/transaction/accept")
			.contentType(MediaType.APPLICATION_JSON)
            .content(acceptTransaction.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());		
	}
	
	@Test
	public void acceptErrorTransactionYaFueAceptada() throws Exception {
		
		TransactionActionDTO acceptTransactionError = new TransactionActionDTO(1,"nacho@gmail.com");
		this.mockMvc.perform(post("/transaction/accept")
			.contentType(MediaType.APPLICATION_JSON)
            .content(acceptTransactionError.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isBadRequest());			
	}
	
	@Test
	public void cancelOk() throws Exception {
		RegisterUserDTO userDTO =  new RegisterUserDTO("nameTestB", "surnameTestB", "nacho@gmail.com", "addressTestB", "123Test#B");	
		this.mockMvc.perform(post("/user/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(userDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		RegisterUserDTO userTwo =  new RegisterUserDTO("nameTestB", "surnameTestB", "otroMail@gmail.com", "addressTestB", "123Test#B");	
		this.mockMvc.perform(post("/user/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(userTwo.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		RegisterIntentionDTO intentionDTO =  new RegisterIntentionDTO("MATICUSDT","7","2,3","nacho@gmail.com","BUY");		
		this.mockMvc.perform(post("/intention/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(intentionDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
				
		RegisterTransactionDTO transactionDTO =  new RegisterTransactionDTO(2, "otroMail@gmail.com");
		this.mockMvc.perform(post("/transaction/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(transactionDTO.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		RegisterTransactionDTO transaction2 =  new RegisterTransactionDTO(1, "otroMail@gmail.com");
		this.mockMvc.perform(post("/transaction/register")
			.contentType(MediaType.APPLICATION_JSON)
            .content(transaction2.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
		
		TransactionActionDTO cancelTransaction = new TransactionActionDTO(2,userDTO.getEmail());
		this.mockMvc.perform(post("/transaction/cancel")
			.contentType(MediaType.APPLICATION_JSON)
            .content(cancelTransaction.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());		
	}
	
	@Test
	public void cancelErrorTransactionYaFueRechazada() throws Exception {
		
		TransactionActionDTO cancelTransactionError = new TransactionActionDTO(2,"nacho@gmail.com");
		this.mockMvc.perform(post("/transaction/cancel")
			.contentType(MediaType.APPLICATION_JSON)
            .content(cancelTransactionError.toString())
            .accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isBadRequest());			
	}
	
	
	
	

}
