package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.converters.Base62;

@Entity
@Table
public class User {
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String surname;
	@Id
	@Column(length = 30)
	private String email;
	@Column(length = 30)
	private String address;
	private String password;
	@Column(length = 22)
	private String cvu;
	@Column(length = 8)
	private String walletAddress;
	private Integer operations;
	private Integer reputationPoints;

	public User() {}
	
	public User(String name, String surname, String email, String address, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.password = password;
		this.operations = 0;
		this.reputationPoints = 0;
	}

	public User(String name, String surname, String email, String address, String password, String cvu, String walletAddress, Integer operations, Integer reputationPoints) {
		this(name, surname, email, address, password);
		
		this.cvu = cvu;
		this.walletAddress = walletAddress;
		this.operations = operations;
		this.reputationPoints = reputationPoints;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCvu() {
		return this.cvu;
	}

	public void setCvu(String cvu) {
		this.cvu = cvu;
	}

	public String getWalletAddress() {
		return this.walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}

	public Integer getOperations() {
		return operations;
	}

	public void setOperations(Integer operations) {
		this.operations = operations;
	}

	public Integer getReputationPoints() {
		return reputationPoints;
	}

	public void setReputationPoints(Integer reputationPoints) {
		this.reputationPoints = reputationPoints;
	}
	
	public String getReputation() {
		return this.operations == 0 ? "Sin operaciones" : String.valueOf(this.reputationPoints / this.operations);
	}
	
	public void initializeCvu(Integer cvuNumber) {
		this.cvu = String.format("%022d", cvuNumber);
	}
	
	public void initializeWalletAddress(Integer cvuNumber) {
		String base62Number = Base62.encode(cvuNumber);
		this.walletAddress = String.format("%0" + (8 - base62Number.length()) + "d%s", 0, base62Number);
	}
}
