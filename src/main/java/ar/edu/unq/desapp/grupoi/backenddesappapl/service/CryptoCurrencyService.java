package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;

@Service
public class CryptoCurrencyService {
	private String urlBase = "https://api1.binance.com/api/v3/ticker/price?symbol=";
	private RestTemplate template = new RestTemplate();
	private List<CryptoCurrency> cryptos;
	private LocalDateTime time;
	
	public List<CryptoCurrency> getCryptos() {
		return cryptos;
	}
	
	public CryptoCurrencyService() {
		//this.updateCryptosEveryTenMinutes();
	}
	
	public CryptoCurrency getCryptoBySymbol(String cryptoSymbol) {
		CryptoSymbol symbol = new ValidCryptoSymbol(cryptoSymbol).getCryptoSymbol();
		CryptoCurrency cryptoTemplate = template.getForObject(urlBase + symbol, CryptoCurrency.class);
		
		return cryptoTemplate;
	}

	public List<CryptoCurrency> getCryptoSymbols() {
		List<CryptoCurrency> cryptoCurrencies = new ArrayList<CryptoCurrency>();
		
		for(CryptoSymbol symbol : CryptoSymbol.values())
			cryptoCurrencies.add(template.getForObject(urlBase + symbol, CryptoCurrency.class));
		
		return cryptoCurrencies;			
	}
	
	
//	private void updateCryptosEveryTenMinutes() {
//		do {
//			this.cryptos = this.getCryptoSymbols();
//			this.time = LocalDateTime.now();
//			try {
//				TimeUnit.MINUTES.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} while(true);
//	}
	

//	public Map<String,Object> asd() {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("time", this.time);
//		map.put("cryptos", this.cryptos);
//		return map;
//	}
	
	
}
