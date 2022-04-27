package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import java.util.regex.Pattern;

public class Validator {
	
	public static boolean isValidPassword(String password) { //throw new InvalidPasswordException("The password is invalid");
		return Pattern.matches("^(?=.{6,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$", password);
	}
	
	public static boolean isValidEmail(String email) {
		return Pattern.matches("[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{1,4}", email);
	}
}
