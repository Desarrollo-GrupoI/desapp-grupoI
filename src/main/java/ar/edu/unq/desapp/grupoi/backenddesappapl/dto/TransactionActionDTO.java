package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransactionActionDTO {
	@NotNull(message = "The transaction action must have a transaction ID")
	private Integer transactionId;
	@NotBlank(message = "The transaction action must have a user email")
	private String userEmail;
	 
	public TransactionActionDTO(Integer transactionId, String userEmail) {
		this.transactionId = transactionId;
		this.userEmail = userEmail;
	}
	
	public Integer getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	public String toString() {
		return "{\"transactionId\": \"" + this.transactionId + "\", \"userEmail\": \"" + this.userEmail + "\"}";
	}
}
