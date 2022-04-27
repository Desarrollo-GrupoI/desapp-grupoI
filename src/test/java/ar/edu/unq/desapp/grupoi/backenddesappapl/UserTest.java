package ar.edu.unq.desapp.grupoi.backenddesappapl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.builders.UserBuilder;

class UserTest {
	
	@Test
	void testEmail() {
		String email = "jose@hotmail.com";
		User user = UserBuilder.aUser().withEmail(email).build();
		Assert.assertEquals(email, user.getEmail());

		String newEmail = "jose@gmail.com";
		user.setEmail(newEmail);
		Assert.assertEquals(newEmail, user.getEmail());
	}
	
	@Test
	void testName() {
		String name = "Jose";
		User user = UserBuilder.aUser().withName(name).build();
		Assert.assertEquals(name, user.getName());
		
		String newName = "Ernesto";
		user.setName(newName);
		Assert.assertEquals(newName, user.getName());
	}

	@Test
	void testSurname() {
		String surname = "Perez";
		User user = UserBuilder.aUser().withSurname(surname).build();
		Assert.assertEquals(surname, user.getSurname());

		String newSurname = "Figueroa";
		user.setSurname(newSurname);
		Assert.assertEquals(newSurname, user.getSurname());
	}
	
	@Test
	void testAddress() {
		String address = "Av. La Plata 3401, B1878 Quilmes, Provincia de Buenos Aires";
		User user = UserBuilder.aUser().withAddress(address).build();
		Assert.assertEquals(address, user.getAddress());

		String newAddress = "Alem 214, Quilmes, Provincia de Buenos Aires";
		user.setAddress(newAddress);
		Assert.assertEquals(newAddress, user.getAddress());
	}

	@Test
	void testPassword() {
		String password = "Password@123";
		User user = UserBuilder.aUser().withPassword(password).build();
		Assert.assertEquals(password, user.getPassword());

		String newPassword = "NewPassword@123";
		user.setPassword(newPassword);
		Assert.assertEquals(newPassword, user.getPassword());
	}
	
	@Test
	void testCvu() {
		String cvu = "7777777777777777777777";
		User user = UserBuilder.aUser().withCvu(cvu).build();
		Assert.assertEquals(cvu, user.getCvu());

		String newCvu = "9999999999999999999999";
		user.setCvu(newCvu);
		Assert.assertEquals(newCvu, user.getCvu());
	}

	@Test
	void testWalletAddress() {
		String walletAddress = "ndfs123jasidm23xc2";
		User user = UserBuilder.aUser().withWalletAddress(walletAddress).build();
		Assert.assertEquals(walletAddress, user.getWalletAddress());
		
		String newWalletAddress = "jksdbjke3ojnaos2s";
		user.setWalletAddress(newWalletAddress);
		Assert.assertEquals(newWalletAddress, user.getWalletAddress());
	}
}
