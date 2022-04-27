package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(length = 40)
	private String email;
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String surname;
	@Column(length = 30)
	private String address;
	@Column
	private String password;
	@Column(length = 22)
	private String cvu;
	@Column(length = 8)
	private String walletAddress;
	
	public User(String email, String name, String surname, String address, String password) {
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.password = password;
	}

	public User(String email, String name, String surname, String address, String password, String cvu, String walletAddress) {
		this(email, name, surname, address, password);
		this.cvu = cvu;
		this.walletAddress = walletAddress;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}
