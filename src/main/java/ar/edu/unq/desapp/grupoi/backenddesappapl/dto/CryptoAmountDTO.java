package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;

public class CryptoAmountDTO {
	private CryptoSymbol cryptoSymbol;
	private Float cryptoAmount;
	
	public CryptoAmountDTO(CryptoSymbol cryptoSymbol, Float cryptoAmount) {
		this.cryptoSymbol = cryptoSymbol;
		this.cryptoAmount = cryptoAmount;
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
}
