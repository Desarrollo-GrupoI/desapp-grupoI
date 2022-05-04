package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import java.util.Date;

public class LastDayQuoteCurrency {
	private CryptoSymbol cryptoCurrency;
	private Date date;
	private Float price;
	
	
	public LastDayQuoteCurrency(CryptoSymbol cryptoCurrency, Float price, Date date) {
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
