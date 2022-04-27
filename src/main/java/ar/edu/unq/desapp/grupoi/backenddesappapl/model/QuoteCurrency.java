package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

public class QuoteCurrency {
	private CryptoCurrency cryptoCurrency;
	private Price price;
	
	public QuoteCurrency(CryptoCurrency cryptoCurrency, Price price) {
		this.cryptoCurrency = cryptoCurrency;
		this.price = price;
	}

	public CryptoCurrency getCryptoCurrency() {
		return this.cryptoCurrency;
	}
	
	public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
		this.cryptoCurrency = cryptoCurrency;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
}
