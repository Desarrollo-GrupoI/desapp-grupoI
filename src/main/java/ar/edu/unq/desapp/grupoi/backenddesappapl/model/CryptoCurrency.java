package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

public class CryptoCurrency {
	private CryptoSymbol cryptoCurrency;
	private Float price;
	
	public CryptoCurrency(CryptoSymbol cryptoCurrency, Float price) {
		this.cryptoCurrency = cryptoCurrency;
		this.price = price;
	}

	public CryptoSymbol getCryptoCurrency() {
		return this.cryptoCurrency;
	}
	
	public void setCryptoCurrency(CryptoSymbol cryptoCurrency) {
		this.cryptoCurrency = cryptoCurrency;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
