package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RegisterIntentionDTO {
	@NotBlank(message = "The intention must have a crypto symbol")
	private String cryptoSymbol;
	
	@NotNull(message = "The intention must have a crypto amount")
    @Pattern(regexp = "^[0-9]+(\\,[0-9]+)?$", message = "Must be a valid crypto amount")
	private String cryptoAmount;
	
	@NotNull(message = "The intention must have a price")
    @Pattern(regexp = "^[0-9]+(\\,[0-9]+)?$", message = "Must be a valid price")
	private String price;
	
	@NotBlank(message = "The intention must have an e-mail")
	private String userEmail;
	
	@NotBlank(message = "The intention must have an operation")
	private String operation;
		
	public RegisterIntentionDTO(String cryptoSymbol, String cryptoAmount, String price, String userEmail, String operation) {
		this.cryptoSymbol = cryptoSymbol;
		this.cryptoAmount = cryptoAmount;
		this.price = price;
		this.userEmail = userEmail;
		this.operation = operation;
	}

	public String getCryptoSymbol() {
		return this.cryptoSymbol;
	}

	public void setCryptoSymbol(String cryptoSymbol) {
		this.cryptoSymbol = cryptoSymbol;
	}

	public Float getCryptoAmount() {
		return Float.valueOf(this.cryptoAmount.replace(",", "."));
	}

	public void setCryptoAmount(String cryptoAmount) {
		this.cryptoAmount = cryptoAmount;
	}

	public Float getPrice() {
		return Float.valueOf(this.price.replace(",", "."));
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "{\"cryptoSymbol\": \"" + this.cryptoSymbol + "\", \"cryptoAmount\": \"" + this.cryptoAmount + "\", \"price\": \"" + this.price + "\", \"userEmail\": \"" + this.userEmail + "\", \"operation\": \"" + this.operation + "\"}";
	}
}
