package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import java.util.Date;

public class LastDayQuoteCurrency {
	private CryptoSymbol cryptoCurrency;
	private Date date;
	private Price price;
	
	
	public LastDayQuoteCurrency(CryptoSymbol cryptoCurrency, Price price, Date date) {
		this.cryptoCurrency = cryptoCurrency;
		this.date = date;
		this.price = price;
	}

	public CryptoSymbol getCryptoCurrency() {
		return this.cryptoCurrency;
	}
	
	public void setCryptoCurrency(CryptoSymbol cryptoCurrency) {
		this.cryptoCurrency = cryptoCurrency;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
