package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	private String email;
	private String name;
	private String surname;
	private String address;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_cvu")
	private Cvu cvu;
	@Column(unique = true)
	private String walletAddress;

	public User() {}
	
	public User(String name, String surname, String email, String address, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.password = password;
		this.cvu = new Cvu();
	}

	public User(String name, String surname, String email, String address, String password, Cvu cvu, String walletAddress) {
		this(email, name, surname, address, password);
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
		return String.format("%022d", this.cvu.getCvu());
	}

	public void setCvu(Cvu cvu) {
		this.cvu = cvu;
	}

	public String getWalletAddress() {
		return this.walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}
}
