package ar.edu.unq.desapp.grupoi.backenddesappapl.model.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringToIntegerConverter implements AttributeConverter <String, Integer> {
	
	@Override
	public Integer convertToDatabaseColumn(String value) {
		if(value != null) {
			try {
				return Integer.parseInt(value);
			} catch(Exception e) {
				throw new IllegalStateException("Invalid number: " + value);
			}
		}
		
		return null;
	}
	
	@Override
	public String convertToEntityAttribute(Integer value) {
		return String.format("%022d", value);
	}
}