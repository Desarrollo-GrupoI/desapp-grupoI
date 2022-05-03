package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.converters.StringToIntegerConverter;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;	
	private String surname;
	@Column(unique = true)
	private String email;	
	private String address;
	private String password;
	@Column(unique = true)
	//@Convert(converter = StringToIntegerConverter.class)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String cvu;
	@Column(unique = true)
	private String walletAddress;
	private Integer operations;
	private String reputation;
	

	public User() {}
	
	public User(String name, String surname, String email, String address, String password, String cvu, String walletAddress) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.password = password;
		this.cvu = cvu;
		this.walletAddress = walletAddress;
		this.operations = 0;
		this.reputation = "No operations";
	}

	/*public User(String email, String name, String surname, String address, String password, String cvu, String walletAddress) {
		this(email, name, surname, address, password);
		this.cvu = cvu;
		this.walletAddress = walletAddress;
	}
	*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOperations() {
		return operations;
	}

	public void setOperations(Integer operations) {
		this.operations = operations;
	}

	public String getReputation() {
		return reputation;
	}

	public void setReputation(String reputation) {
		this.reputation = reputation;
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
