package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import java.time.LocalDateTime;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;

public class IntentionDTO {
	private LocalDateTime date;
	private CryptoSymbol cryptoSymbol;
	private Float cryptoAmount;
	private Float price;
	private Float pesosArgPrice;
	private Operation operation;
	private String name;
	private String surname;
	private Integer operations;
	private String reputation;
		
	public IntentionDTO(LocalDateTime date, CryptoSymbol cryptoSymbol, Float cryptoAmount, Float price,
		Float pesosArgPrice, Operation operation,String name, String surname, Integer operations, String reputation) {
		this.date = date;
		this.cryptoSymbol = cryptoSymbol;
		this.cryptoAmount = cryptoAmount;
		this.price = price;
		this.pesosArgPrice = pesosArgPrice;
		this.operation = operation;
		this.name = name;
		this.surname = surname;
		this.operations = operations;
		this.reputation = reputation;
	}
	
	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
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
	
	public Integer getOperations() {
		return operations;
	}
	
	public void setOperations(Integer operations) {
		this.operations = operations;
	}
	public String getReputation() {
		return reputation;
	}
	
	public void setReputation(String reputation) {
		this.reputation = reputation;
	}
}
