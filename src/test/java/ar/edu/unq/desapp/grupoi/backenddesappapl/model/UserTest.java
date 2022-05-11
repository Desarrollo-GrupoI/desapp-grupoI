package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.builders.UserBuilder;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.converters.Base62;

class UserTest {
	
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
	void testEmail() {
		String email = "jose@hotmail.com";
		User user = UserBuilder.aUser().withEmail(email).build();
		Assert.assertEquals(email, user.getEmail());

		String newEmail = "jose@gmail.com";
		user.setEmail(newEmail);
		Assert.assertEquals(newEmail, user.getEmail());
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
		String cvu = "0000000000000000000001";
		User user = UserBuilder.aUser().withCvu(cvu).build();
		Assert.assertEquals(cvu, user.getCvu());

		String newCvu = "0000000000000000000002";
		user.setCvu(newCvu);
		Assert.assertEquals(newCvu, user.getCvu());
	}

	@Test
	void testWalletAddress() {
		String walletAddress = "skrm34lC";
		User user = UserBuilder.aUser().withWalletAddress(walletAddress).build();
		Assert.assertEquals(walletAddress, user.getWalletAddress());
		
		String newWalletAddress = "lKf3jgmf";
		user.setWalletAddress(newWalletAddress);
		Assert.assertEquals(newWalletAddress, user.getWalletAddress());
	}
	
	@Test
	void testUserSetters() {
		User user = new User();
		
		String email = "a@a.a";
		user.setEmail(email);
		Assert.assertEquals(email, user.getEmail());
		
		String name = "juan";
		user.setName(name);
		Assert.assertEquals(name, user.getName());
		
		String surname = "perez";
		user.setSurname(surname);
		Assert.assertEquals(surname, user.getSurname());
		
		String address = "Av. La Plata";
		user.setAddress(address);
		Assert.assertEquals(address, user.getAddress());
		
		String password = "Pas$word";
		user.setPassword(password);
		Assert.assertEquals(password, user.getPassword());
		
		String cvu = "0000000000000000000003";
		user.setCvu(cvu);
		Assert.assertEquals(cvu, user.getCvu());
		
		String walletAddress = "sdw2gb4d";
		user.setWalletAddress(walletAddress);
		Assert.assertEquals(walletAddress, user.getWalletAddress());
	}
	
	@Test
	void testUserInitializers() {
		User user = new User();
		
		Integer cvuNumber = 7;
		
		String cvu = String.format("%022d", cvuNumber);
		user.initializeCvu(cvuNumber);
		Assert.assertEquals(cvu, user.getCvu());
		
		String walletAddressWithoutFormat = Base62.encode(cvuNumber);
		String walletAddress = String.format("%0" + (8 - walletAddressWithoutFormat.length()) + "d%s", 0, walletAddressWithoutFormat);
		user.initializeWalletAddress(cvuNumber);
		Assert.assertEquals(walletAddress, user.getWalletAddress());
	}
}
