package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegisterTransactionActionDTO {
	@NotNull(message = "The transaction must have a intention ID")
	private Integer intentionId;
	@NotNull(message = "The transaction action must have a transaction ID")
	private Integer transactionId;
	@NotBlank(message = "The transaction action must have a user email")
	private String userEmail;
	 
	public RegisterTransactionActionDTO(Integer intentionId, Integer transactionId, String userEmail) {
		this.intentionId = intentionId;
		this.transactionId = transactionId;
		this.userEmail = userEmail;
	}
	
	public Integer getIntentionId() {
		return intentionId;
	}
	
	public void setIntentionId(Integer intentionId) {
		this.intentionId = intentionId;
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
		return "{\"intentionId\": \"" + this.intentionId + "\", \"transactionId\": \"" + this.transactionId + "\", \"userEmail\": \"" + this.userEmail + "\"}";
	}
}
