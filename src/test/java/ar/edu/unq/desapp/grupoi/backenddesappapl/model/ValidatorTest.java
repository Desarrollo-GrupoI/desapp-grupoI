package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.Validator;


class ValidatorTest {
	
	@Test
	void testValidatePassword() {
		String validPasswordA = "Password@";
		String validPasswordB = "Passw@";
		String invalidPasswordA = "password@";
		String invalidPasswordB = "PASSWORD@";
		String invalidPasswordC = "Password";
		String invalidPasswordD = "Pass@";
		
		Assert.assertTrue(Validator.isValidPassword(validPasswordA));
		Assert.assertTrue(Validator.isValidPassword(validPasswordB));
		Assert.assertFalse(Validator.isValidPassword(invalidPasswordA));
		Assert.assertFalse(Validator.isValidPassword(invalidPasswordB));
		Assert.assertFalse(Validator.isValidPassword(invalidPasswordC));
		Assert.assertFalse(Validator.isValidPassword(invalidPasswordD));
	}

	@Test
	void testValidateEmail() {
		String validEmailA = "m@h.c";
		String validEmailB = "m@hotmail.com";
		String invalidEmailA = "@hotmail.com";
		String invalidEmailB = "m@.com";
		String invalidEmailC = "m@hotmail.";
		
		Assert.assertTrue(Validator.isValidEmail(validEmailA));
		Assert.assertTrue(Validator.isValidEmail(validEmailB));
		Assert.assertFalse(Validator.isValidEmail(invalidEmailA));
		Assert.assertFalse(Validator.isValidEmail(invalidEmailB));
		Assert.assertFalse(Validator.isValidEmail(invalidEmailC));
	}
}
