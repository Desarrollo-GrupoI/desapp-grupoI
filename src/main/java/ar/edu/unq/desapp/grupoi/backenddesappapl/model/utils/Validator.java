package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.InvalidUserBody;

public class Validator {
	
	public static boolean isValidEmail(String email) {
		return Pattern.matches("^[a-zA-Z]+[a-zA-Z._-]*@[a-zA-Z]+\\.[a-zA-Z^s]+$", email);
	}
	
	public static boolean isValidName(String name) {
		Integer nameLength = name.length();
		return nameLength >= 3 && nameLength <= 30;
	}
	
	public static boolean isValidSurname(String surname) {
		Integer surnameLength = surname.length();
		return surnameLength >= 3 && surnameLength <= 30;
	}
	
	public static boolean isValidAddress(String address) {
		Integer addressLength = address.length();
		return addressLength >= 10 && addressLength <= 30;
	}
	
	public static boolean isValidPassword(String password) {
		return Pattern.matches("^(?=.{6,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$", password);
	}
	
	public static void validateUser(RegisterUserDTO user) {
		String errorMessageBase = "Error(s) in user body:";
		List<String> errorMessages = new ArrayList<String>();
		
		if(!Validator.isValidEmail(user.getEmail()))
			errorMessages.addAll(messageError(user.getEmail(),"Email cannot be empty","Invalid email"));
			
		if(!Validator.isValidName(user.getName()))
			errorMessages.addAll(messageError(user.getName(),"Name cannot be empty","The name must be between 3 and 30 characters"));
		
		if(!Validator.isValidSurname(user.getSurname()))
			errorMessages.addAll(messageError(user.getSurname(),"Surname cannot be empty","The surname must be between 3 and 30 characters"));
			
		if(!Validator.isValidAddress(user.getAddress()))
			errorMessages.addAll(messageError(user.getAddress(),"Address cannot be empty","The adress must be between 10 and 30 characters"));
			
		if(!Validator.isValidPassword(user.getPassword()))
			errorMessages.addAll(messageError(user.getPassword(),"The password cannot be empty","Invalid password"));

		if(!errorMessages.isEmpty())
			throw new InvalidUserBody(errorMessageBase + String.join("", errorMessages));
	}
	
	
	public static List<String> messageError(String data, String messageFirstError, String messageLastError) {
		List<String> errorMessages = new ArrayList<String>();
		
		if (data.length() == 0)
			errorMessages.add("\n\u2022" + messageFirstError);
		else
			errorMessages.add("\n\u2022" + messageLastError);
	
		return errorMessages;
	}
}
