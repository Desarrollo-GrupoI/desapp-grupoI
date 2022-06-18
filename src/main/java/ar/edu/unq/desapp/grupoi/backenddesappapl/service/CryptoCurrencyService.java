package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;

@Service
public class CryptoCurrencyService {
	private String baseUrl = "https://api1.binance.com/api/v3/ticker/price?symbol=";
	private RestTemplate template = new RestTemplate();
	
	public CryptoCurrencyService() {}
	
	public CryptoCurrency getCryptoBySymbol(String cryptoSymbol) {
		CryptoSymbol symbol = new ValidCryptoSymbol(cryptoSymbol).getCryptoSymbol();
		
		return template.getForObject(baseUrl + symbol, CryptoCurrency.class);
	}
	
	@Transactional
	@Cacheable(value = "cryptoSymbols")
	public List<CryptoCurrency> getCryptoSymbols() {
		List<CryptoCurrency> cryptoCurrencies = new ArrayList<CryptoCurrency>();
		
		for(CryptoSymbol symbol : CryptoSymbol.values())
			cryptoCurrencies.add(template.getForObject(baseUrl + symbol, CryptoCurrency.class));
		
		return cryptoCurrencies;			
	}
}
