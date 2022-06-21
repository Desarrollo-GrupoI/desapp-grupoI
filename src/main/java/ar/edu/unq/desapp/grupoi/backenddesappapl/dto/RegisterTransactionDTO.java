package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegisterTransactionDTO {
	@NotNull(message = "The transaction must have a intention ID")
	private Integer intentionId;
	@NotBlank(message = "The transaction must have a user email")
	private String userEmail;
	 
	public RegisterTransactionDTO(Integer intentionId, String userEmail) {
		this.intentionId = intentionId;
		this.userEmail = userEmail;
	}
	
	public Integer getIntentionId() {
		return intentionId;
	}
	
	public void setIntentionId(Integer intentionId) {
		this.intentionId = intentionId;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	public String toString() {
		return "{\"intentionId\": \"" + this.intentionId + "\", \"userEmail\": \"" + this.userEmail + "\"}";
	}
}
