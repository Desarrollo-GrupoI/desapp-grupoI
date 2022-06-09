package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegisterTransactionDTO {
	
	@NotNull(message = "The transaction must have a intention ID")
	private Integer intentionId;
	@NotBlank(message = "The transaction must have a user ID")
	private String userId;
	
	public RegisterTransactionDTO(Integer intentionId, String userId) {
		this.intentionId = intentionId;
		this.userId = userId;
	}
	
	public Integer getIntentionId() {
		return intentionId;
	}
	public void setIntentionId(Integer intentionId) {
		this.intentionId = intentionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
