package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

import javax.validation.constraints.NotBlank;

public class DatePeriodDTO {
	@NotBlank(message = "Date period must have a 'dateFrom'")
	private String dateFrom;
	
	@NotBlank(message = "Date period must have a 'dateTo'")
	private String dateTo;
	
	public DatePeriodDTO(String dateFrom, String dateTo) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public String getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	@Override
	public String toString() {
		return "{dateFrom: " + this.dateFrom + ", dateTo: " + this.dateTo + "}";
	}
}
