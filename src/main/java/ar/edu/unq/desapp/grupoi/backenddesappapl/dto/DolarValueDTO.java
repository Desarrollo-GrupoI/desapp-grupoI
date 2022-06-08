package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DolarValueDTO {
	@JsonProperty("compra")
	private String buyValue;
	
	@JsonProperty("venta")
	private String sellValue;
	
	@JsonProperty("nombre")
	private String name;

	public DolarValueDTO() {}

	public DolarValueDTO(String buyValue, String sellValue, String name) {
		this.buyValue = buyValue;
		this.sellValue = sellValue;
		this.name = name;
	}

	public Float getBuyValue() {
		return Float.valueOf(this.buyValue.replace(",", "."));
	}

	public void setBuyValue(String buyValue) {
		this.buyValue = buyValue;
	}

	public Float getSellValue() {
		return Float.valueOf(this.sellValue.replace(",", "."));
	}

	public void setSellValue(String sellValue) {
		this.sellValue = sellValue;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
