package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_intention")
public class Intention {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Enumerated(EnumType.STRING)
	@Column(name = "crypto_symbol")
	private CryptoSymbol cryptoSymbol;
	@Column(name = "crypto_amount")
	private Float cryptoAmount;
	@Column(name = "price")
	private Float price;
	@Column(name = "pesos_amount")
	private Float pesosArgAmount;
	@OneToOne
	@JoinColumn(name="user_email")
	private User user;
	@Enumerated(EnumType.STRING)
	@Column(name = "operation")
	private Operation operation;
	@Column(name = "date")
	private LocalDateTime date = LocalDateTime.now();
	
	public Intention() {}
	
	public Intention(CryptoSymbol cryptoSymbol,Float cryptoAmount, Float price, Float pesosArgAmount, User user, Operation operation) {
		this.cryptoSymbol = cryptoSymbol;
		this.cryptoAmount = cryptoAmount;
		this.price = price;
		this.pesosArgAmount = pesosArgAmount;
		this.user= user;
		this.operation = operation;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public CryptoSymbol getCryptoSymbol() {
		return this.cryptoSymbol;
	}
	
	public void setCryptoSymbol(CryptoSymbol cryptoSymbol) {
		this.cryptoSymbol = cryptoSymbol;
	}
		
	public Float getCryptoAmount() {
		return this.cryptoAmount;
	}

	public void setCryptoAmount(Float cryptoAmount) {
		this.cryptoAmount = cryptoAmount;
	}
	
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getPesosArgAmount() {
		return this.pesosArgAmount;
	}

	public void setPesosArgAmount(Float pesosArgAmount) {
		this.pesosArgAmount = pesosArgAmount;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Operation getOperation() {
		return this.operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
