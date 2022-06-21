package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import java.time.LocalDateTime;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;

public class IntentionOperationDTO {
	
	private LocalDateTime date;
	private CryptoSymbol cryptoSymbol;
	private Float cryptoAmount;
	private Float price;
	private Float pesosArgPrice;
	private String name;
	private String surname;
	private Operation operation;
		
	public IntentionOperationDTO(LocalDateTime date, CryptoSymbol cryptoSymbol, Float cryptoAmount, Float price,
		Float pesosArgPrice, String name, String surname, Operation operation) {
		this.date = date;
		this.cryptoSymbol = cryptoSymbol;
		this.cryptoAmount = cryptoAmount;
		this.price = price;
		this.pesosArgPrice = pesosArgPrice;
		this.name = name;
		this.surname = surname;
		this.operation = operation;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public CryptoSymbol getCryptoSymbol() {
		return cryptoSymbol;
	}

	public void setCryptoSymbol(CryptoSymbol cryptoSymbol) {
		this.cryptoSymbol = cryptoSymbol;
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

	public Float getPesosArgPrice() {
		return pesosArgPrice;
	}

	public void setPesosArgPrice(Float pesosArgPrice) {
		this.pesosArgPrice = pesosArgPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	

}
