package ar.edu.unq.desapp.grupoi.backenddesappapl.model.builders;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;

public class UserBuilder {
	private String name = "noName";
	private String surname = "noSurname";
	private String email = "noEmail";
	private String address = "noAddress";
	private String password = "noPassword";
	private String cvu = "0000000000000000000000";
	private String walletAddress = "noWalletAddress";
	private Integer operations = 0;
	private Integer reputationPoints = 0;
	
	public static UserBuilder aUser() {
		return new UserBuilder();
	}
	
	public User build() {
		return new User(this.name, this.surname, this.email, this.address, this.password, this.cvu, this.walletAddress, this.operations, this.reputationPoints);
	}
	
	public UserBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public UserBuilder withSurname(String surname) {
		this.surname = surname;
		return this;
	}
	
	public UserBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public UserBuilder withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserBuilder withCvu(String cvu) {
		this.cvu = cvu;
		return this;
	}
	
	public UserBuilder withWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
		return this;
	}
	
	public UserBuilder withOperations(Integer operations) {
		this.operations = operations;
		return this;
	}
	
	public UserBuilder withReputationPoints(Integer reputationPoints) {
		this.reputationPoints = reputationPoints;
		return this;
	}
}
