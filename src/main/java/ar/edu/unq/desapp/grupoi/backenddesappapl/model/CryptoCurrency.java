package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

public class CryptoCurrency {
	private CryptoSymbol cryptoActive;
	private Float price;
	
	public CryptoCurrency(CryptoSymbol cryptoActive, Float price) {
		this.cryptoActive = cryptoActive;
		this.price = price;
	}

	public CryptoSymbol getCryptoCurrency() {
		return this.cryptoActive;
	}
	
	public void setCryptoCurrency(CryptoSymbol cryptoActive) {
		this.cryptoActive = cryptoActive;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
