package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import java.io.Serializable;

public class CryptoCurrency implements Serializable {
	private static final long serialVersionUID = 6453824877650465212L;
	private CryptoSymbol symbol;
	private Float price;
		
	public CryptoCurrency() {}
	
	public CryptoCurrency(CryptoSymbol symbol, Float price) {
		this.symbol = symbol;
		this.price = price;
	}

	public CryptoSymbol getSymbol() {
		return this.symbol;
	}
	
	public void setSymbol(CryptoSymbol symbol) {
		this.symbol = symbol;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
