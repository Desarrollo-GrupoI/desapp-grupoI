//package ar.edu.unq.desapp.grupoi.backenddesappapl.service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;
//
//@Service
//public class SystemService extends Thread {
//	private LocalDateTime lastUpdate;
//	private List<CryptoCurrency> cryptoCurrencies;
//	@Autowired
//	private CryptoCurrencyService cryptoCurrencyService;
//	
//	public SystemService() {
//		this.run();
//	}
//	
//	public void run() {
//    	while(!Thread.currentThread().isInterrupted()) {
//    	    try {
//    	    	System.out.println("Actualizando cryptos");
//    	    	//this.setCryptoCurrencies(cryptoCurrencyService.getCryptos());
//    	        wait(5000);
//    	    } catch (InterruptedException ex) {
//    	        Thread.currentThread().interrupt();
//    	    }
//    	}
//    }
//
//	public LocalDateTime getLastUpdate() {
//		return lastUpdate;
//	}
//
//	public void setLastUpdate(LocalDateTime lastUpdate) {
//		this.lastUpdate = lastUpdate;
//	}
//
//	public List<CryptoCurrency> getCryptoCurrencies() {
//		return cryptoCurrencies;
//	}
//
//	public void setCryptoCurrencies(List<CryptoCurrency> cryptoCurrencies) {
//		this.cryptoCurrencies = cryptoCurrencies;
//	}
//}
