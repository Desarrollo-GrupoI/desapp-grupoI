package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

public class Transaction {
	
	private Long id;
	private IntentionBuySell transactionIntention;
	private CryptoCurrency criptoActive;
	private Float cryptoAmount;
	private Float price;
	private Float pesosArgAmount;
	private String userName;
	private String userLastName;
	private Operation operation;
	private TransactionState state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public IntentionBuySell getTransactionIntention() {
		return transactionIntention;
	}
	public void setTransactionIntention(IntentionBuySell transactionIntention) {
		this.transactionIntention = transactionIntention;
	}
	public CryptoCurrency getCriptoActive() {
		return criptoActive;
	}
	public void setCriptoActive(CryptoCurrency criptoActive) {
		this.criptoActive = criptoActive;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public TransactionState getState() {
		return state;
	}
	public void setState(TransactionState state) {
		this.state = state;
	}

}
