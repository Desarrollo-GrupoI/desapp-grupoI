package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;

public class RegisterIntentionDTO {
	
	private CryptoSymbol cryptoCurrency;
	private Float cryptoAmount;
	private Float price;
	private String userEmail;
	private Operation operation;
		
	public RegisterIntentionDTO(CryptoSymbol cryptoCurrency, Float cryptoAmount, Float price,String userEmail, Operation operation) {
		this.cryptoCurrency = cryptoCurrency;
		this.cryptoAmount = cryptoAmount;
		this.price = price;
		this.userEmail = userEmail;
		this.operation = operation;
	}
	public CryptoSymbol getCryptoCurrency() {
		return cryptoCurrency;
	}
	public void setCryptoCurrency(CryptoSymbol cryptoCurrency) {
		this.cryptoCurrency = cryptoCurrency;
	}
	public Float getCryptoAmount() {
		return cryptoAmount;
	}
	public void setCryptoAmount(Float cryptoAmount) {
		this.cryptoAmount = cryptoAmount;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
