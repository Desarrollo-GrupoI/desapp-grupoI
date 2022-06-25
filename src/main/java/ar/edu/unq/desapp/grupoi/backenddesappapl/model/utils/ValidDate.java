package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.InvalidArgumentsException;

public class ValidDate {
	private LocalDateTime date;
	
	public ValidDate(String dateString) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			this.date = LocalDateTime.parse(dateString, formatter);
		} catch(DateTimeParseException  exception) {
			throw new InvalidArgumentsException("The date '" + dateString + "' is not valid, follow the 'yyyy-MM-dd HH:mm' format");
		}
	}

	public LocalDateTime getDate() {
		return this.date;
	}
}
