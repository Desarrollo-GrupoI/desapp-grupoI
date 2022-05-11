package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import java.util.Date;

public class LastDayQuoteCurrency {
	private CryptoSymbol cryptoActive;
	private Date date;
	private Float price;
	
	public LastDayQuoteCurrency(CryptoSymbol cryptoActive, Float price, Date date) {
		this.cryptoActive = cryptoActive;
		this.date = date;
		this.price = price;
	}

	public CryptoSymbol getCryptoActive() {
		return this.cryptoActive;
	}
	
	public void setCryptoActive(CryptoSymbol cryptoActive) {
		this.cryptoActive = cryptoActive;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
