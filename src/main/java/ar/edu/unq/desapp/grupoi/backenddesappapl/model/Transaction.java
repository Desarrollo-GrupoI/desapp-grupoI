package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@OneToOne
	@JoinColumns({
		@JoinColumn(name = "transaction_intention_id", referencedColumnName = "id"),
		@JoinColumn(name = "cripto_symbol", referencedColumnName = "crypto_symbol"),
		@JoinColumn(name = "cripto_amount", referencedColumnName = "crypto_amount"),
		@JoinColumn(name = "price", referencedColumnName = "price"),
		@JoinColumn(name = "pesos_amount", referencedColumnName = "pesos_amount"),
		@JoinColumn(name = "operation", referencedColumnName = "operation")
	})
	private Intention transactionIntention;
	@OneToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
	private User user;
	@Column(name = "state")
	private TransactionState state;
	
	public Transaction(Intention transactionIntention, User user) {
		this.transactionIntention = transactionIntention;
		this.user = user;
		this.state = TransactionState.WAITING;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Intention getTransactionIntention() {
		return this.transactionIntention;
	}
	
	public void setTransactionIntention(Intention transactionIntention) {
		this.transactionIntention = transactionIntention;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public TransactionState getState() {
		return this.state;
	}
	
	public void setState(TransactionState state) {
		this.state = state;
	}
}
