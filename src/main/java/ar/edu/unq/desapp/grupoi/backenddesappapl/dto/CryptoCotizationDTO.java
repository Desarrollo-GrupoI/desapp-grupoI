package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import java.time.LocalDateTime;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;

public class CryptoCotizationDTO {
	
	private CryptoSymbol symbol;
	private Float price;
	private LocalDateTime date;
	
	public CryptoCotizationDTO(CryptoSymbol symbol, Float price) {
		this.symbol = symbol;
		this.price = price;
		this.date = LocalDateTime.now();
	}
	public CryptoSymbol getSymbol() {
		return symbol;
	}
	public void setSymbol(CryptoSymbol symbol) {
		this.symbol = symbol;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	

}
