package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.CryptoSymbolNotFound;

public class ValidCryptoSymbol {
	private CryptoSymbol cryptoSymbol;
	
	public ValidCryptoSymbol(String cryptoSymbol) {
		try {
			this.cryptoSymbol = CryptoSymbol.valueOf(cryptoSymbol.toUpperCase());
		} catch(IllegalArgumentException exception) {
			throw new CryptoSymbolNotFound("The crypto symbol '" + cryptoSymbol + "' was not found");
		}
	}

	public CryptoSymbol getCryptoSymbol() {
		return this.cryptoSymbol;
	}
}
