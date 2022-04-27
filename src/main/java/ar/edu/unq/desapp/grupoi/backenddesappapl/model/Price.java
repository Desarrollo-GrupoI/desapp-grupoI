package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

public class Price {
	private Float buyPrice;
	private Float sellPrice;
	
	public Price(Float buyPrice, Float sellPrice) {
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	public Float getBuyPrice() {
		return this.buyPrice;
	}
	
	public void setBuyPrice(Float buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	public Float getSellPrice() {
		return this.sellPrice;
	}
	
	public void setSellPrice(Float sellPrice) {
		this.sellPrice = sellPrice;
	}
}
