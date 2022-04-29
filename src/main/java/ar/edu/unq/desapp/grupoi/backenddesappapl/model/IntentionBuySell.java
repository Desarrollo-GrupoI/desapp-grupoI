package ar.edu.unq.desapp.grupoi.backenddesappapl.model;

public class IntentionBuySell {
	private CryptoCurrency cryptoCurrency;
	private Float cryptoAmount;
	private Price price;
	private Float pesosArgAmount;
	private String userName;
	private String userLastName;
	private Operation operation;
	
	public IntentionBuySell(CryptoCurrency cryptoCurrency,Float cryptoAmount, Price price, Float pesosArgAmount, String userName, String userLastName, Operation operation) {
		this.cryptoCurrency = cryptoCurrency;
		this.cryptoAmount = cryptoAmount;
		this.price = price;
		this.pesosArgAmount = pesosArgAmount;
		this.userName = userName;
		this.userLastName = userLastName;		
		this.operation = operation;
	}
	
	public CryptoCurrency getCryptoCurrency() {
		return this.cryptoCurrency;
	}
	
	public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
		this.cryptoCurrency = cryptoCurrency;
	}
		
	public Float getCryptoAmount() {
		return cryptoAmount;
	}

	public void setCryptoAmount(Float cryptoAmount) {
		this.cryptoAmount = cryptoAmount;
	}
	
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	public Float getPesosArgAmount() {
		return pesosArgAmount;
	}

	public void setPesosArgAmount(Float pesosArgAmount) {
		this.pesosArgAmount = pesosArgAmount;
	}
	
	public String getUserName() {
		return userName ;
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
}
