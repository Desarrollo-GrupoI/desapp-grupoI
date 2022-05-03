package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

public class QuoteCurrency {
	private CryptoSymbol cryptoCurrency;
	private Float price;
	
	public QuoteCurrency(CryptoSymbol cryptoCurrency, Float price) {
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
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
