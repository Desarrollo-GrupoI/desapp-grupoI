package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import java.time.LocalDateTime;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.TransactionState;

public class TransactionDTO {
	
	private Integer intention_id;
	private LocalDateTime dateIntention;
	private CryptoSymbol cryptoSymbol;
	private Float cryptoAmount;
	private Float price;
	private Float pesosArgPrice;
	private TransactionState state;
	private String name;
	private String surname;
	private Integer operations;
	private String reputation;
	
	
	public TransactionDTO(Integer intention_id, LocalDateTime dateIntention, CryptoSymbol cryptoSymbol,
			Float cryptoAmount, Float price, Float pesosArgPrice, TransactionState state, String name, String surname,
			Integer operations, String reputation) {
		this.intention_id = intention_id;
		this.dateIntention = dateIntention;
		this.cryptoSymbol = cryptoSymbol;
		this.cryptoAmount = cryptoAmount;
		this.price = price;
		this.pesosArgPrice = pesosArgPrice;
		this.state = state;
		this.name = name;
		this.surname = surname;
		this.operations = operations;
		this.reputation = reputation;
	}
	public Integer getIntention_id() {
		return intention_id;
	}
	public void setIntention_id(Integer intention_id) {
		this.intention_id = intention_id;
	}
	public LocalDateTime getDateIntention() {
		return dateIntention;
	}
	public void setDateIntention(LocalDateTime dateIntention) {
		this.dateIntention = dateIntention;
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
	public TransactionState getState() {
		return state;
	}
	public void setState(TransactionState state) {
		this.state = state;
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
