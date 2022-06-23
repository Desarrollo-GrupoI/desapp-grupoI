package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import java.time.LocalDateTime;

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
@Table(name = "transaction")
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name = "intention_id", referencedColumnName = "id")
	private Intention transactionIntention;
	@Enumerated(EnumType.STRING)
	private CryptoSymbol cryptoSymbol;
	private Float cryptoAmount;
	private Float price;
	private Float pesosArgAmount;
	@OneToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
	private User user;
	private String sendAddress;
	@Enumerated(EnumType.STRING)
	private TransactionState state;
	private LocalDateTime date = LocalDateTime.now();
	
	public Transaction() {}
	
	public Transaction(Intention transactionIntention, User user, TransactionState state) {
		this.transactionIntention = transactionIntention;
		this.cryptoSymbol = transactionIntention.getCryptoSymbol();
		this.cryptoAmount = transactionIntention.getCryptoAmount();
		this.price = transactionIntention.getPrice();
		this.pesosArgAmount = transactionIntention.getPesosArgAmount();
		this.user = user;
		this.sendAddress = transactionIntention.getOperation() == Operation.SELL ? transactionIntention.getUser().getCvu() : transactionIntention.getUser().getWalletAddress();
		this.state = state;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Intention getTransactionIntention() {
		return transactionIntention;
	}
	
	public void setTransactionIntention(Intention transactionIntention) {
		this.transactionIntention = transactionIntention;
	}
	
	public CryptoSymbol getCryptoSymbol() {
		return cryptoSymbol;
	}
	
	public void setCryptoSymbol(CryptoSymbol cryptoSymbol) {
		this.cryptoSymbol = cryptoSymbol;
	}
	
	public Float getCryptoAmount() {
		return cryptoAmount;
	}
	
	public void setCryptoAmount(Float cryptoAmount) {
		this.cryptoAmount = cryptoAmount;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getPesosArgAmount() {
		return pesosArgAmount;
	}
	
	public void setPesosArgAmount(Float pesosArgAmount) {
		this.pesosArgAmount = pesosArgAmount;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	
	public TransactionState getState() {
		return state;
	}
	
	public void setState(TransactionState state) {
		this.state = state;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
