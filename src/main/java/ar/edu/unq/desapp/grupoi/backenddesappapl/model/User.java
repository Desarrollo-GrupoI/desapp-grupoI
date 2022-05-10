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

	public User() {}
	
	public User(String name, String surname, String email, String address, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public User(String name, String surname, String email, String address, String password, String cvu, String walletAddress) {
		this(name, surname, email, address, password);
		this.cvu = cvu;
		this.walletAddress = walletAddress;
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
	
	public void initializeCvu(Integer cvuNumber) {
		this.cvu = String.format("%022d", cvuNumber);
	}
	
	public void initializeWalletAddress(Integer cvuNumber) {
		String base62Number = Base62.encode(cvuNumber);
		this.walletAddress = String.format("%0" + (8 - base62Number.length()) + "d%s", 0, base62Number);
	}
}
