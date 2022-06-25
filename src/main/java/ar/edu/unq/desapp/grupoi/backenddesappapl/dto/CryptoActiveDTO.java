package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;

public class CryptoActiveDTO {
	private CryptoSymbol cryptoSymbol;
	private Float cryptoAmount;
	private Float price;
	private Float pesosArgAmount;
	
	public CryptoActiveDTO(CryptoSymbol cryptoSymbol, Float cryptoAmount, Float price, Float pesosArgAmount) {
		this.cryptoSymbol = cryptoSymbol;
		this.cryptoAmount = cryptoAmount;
		this.price = price;
		this.pesosArgAmount = pesosArgAmount;
	}
	
	public CryptoSymbol getCryptoSymbol() {
		return this.cryptoSymbol;
	}
	
	public void setCryptoSymbol(CryptoSymbol cryptoSymbol) {
		this.cryptoSymbol = cryptoSymbol;
	}
	
	public Float getCryptoAmount() {
		return this.cryptoAmount;
	}
	
	public void setCryptoAmount(Float cryptoAmount) {
		this.cryptoAmount = cryptoAmount;
	}
	
	public Float getPrice() {
		return this.price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getPesosArgAmount() {
		return this.pesosArgAmount;
	}
	
	public void setPesosArgAmount(Float pesosArgAmount) {
		this.pesosArgAmount = pesosArgAmount;
	}
}
