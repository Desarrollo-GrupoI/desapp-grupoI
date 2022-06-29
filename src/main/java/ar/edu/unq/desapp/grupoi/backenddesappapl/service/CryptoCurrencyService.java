package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;

@Service
public class CryptoCurrencyService {
	private String baseUrl = "https://api1.binance.com/api/v3/ticker/price?symbol=";
	private RestTemplate template = new RestTemplate();
	private Map<LocalDateTime, List<CryptoCurrency>> cryptoCurrencies = new HashMap<LocalDateTime, List<CryptoCurrency>>();	
	
	public CryptoCurrencyService() {}
	
	public CryptoCurrency getCryptoBySymbol(CryptoSymbol symbol) {		
		return this.template.getForObject(baseUrl + symbol, CryptoCurrency.class);
	}
	
	public CryptoCurrency getCryptoBySymbol(String cryptoSymbol) {
		CryptoSymbol symbol = new ValidCryptoSymbol(cryptoSymbol).getCryptoSymbol();
		
		return this.template.getForObject(baseUrl + symbol, CryptoCurrency.class);
	}
	
	@Transactional
	@Cacheable(value = "cryptoSymbols")
	public List<CryptoCurrency> getCryptoSymbols() {
		List<CryptoCurrency> cryptoCurrencies = new ArrayList<CryptoCurrency>();
		
		for(CryptoSymbol symbol : CryptoSymbol.values())
			cryptoCurrencies.add(this.template.getForObject(baseUrl + symbol, CryptoCurrency.class));
		 
		return cryptoCurrencies;
	}
	
	public Map<LocalDateTime, List<CryptoCurrency>> getCryptosCurrenciesHistory() {		
		return this.cryptoCurrencies;
	}
	
	@Transactional
	@Scheduled(cron = "*/20 * * * * ?" )
	public void addCryptosCurrenciesToHistory() {
		this.cryptoCurrencies.put(LocalDateTime.now(), this.getCryptoSymbols());
	}
}
