package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFoundException;

public class ValidCryptoSymbol {
	private CryptoSymbol cryptoSymbol;
	
	public ValidCryptoSymbol(String cryptoSymbol) {
		try {
			this.cryptoSymbol = CryptoSymbol.valueOf(cryptoSymbol.toUpperCase());
		} catch(IllegalArgumentException exception) {
			throw new EntityNotFoundException("The crypto symbol '" + cryptoSymbol + "' was not found");
		}
	}

	public CryptoSymbol getCryptoSymbol() {
		return this.cryptoSymbol;
	}
}
