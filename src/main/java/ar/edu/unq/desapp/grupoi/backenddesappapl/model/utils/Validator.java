package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.InvalidUserBody;

public class Validator {
	
	public static boolean isValidPassword(String password) { //throw new InvalidPasswordException("The password is invalid");
		return Pattern.matches("^(?=.{6,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$", password);
	}
	
	public static boolean isValidEmail(String email) {
		return Pattern.matches("^[a-zA-Z]+[a-zA-Z._-]*@[a-zA-Z]+\\.[a-zA-Z^s]+$", email);
	}
	
	public static void validateUser(User user) {
		String errorMessageBase = "Error(s) in user body:";
		List<String> errorMessages = new ArrayList<String>();
		
		if(!Validator.isValidPassword(user.getPassword()))
			errorMessages.add("\n\u2022Invalid password");
		
		if(!Validator.isValidEmail(user.getEmail()))
			errorMessages.add("\n\u2022Invalid email");
		
		if(!errorMessages.isEmpty())
			throw new InvalidUserBody(errorMessageBase + String.join("", errorMessages));
	}
}
