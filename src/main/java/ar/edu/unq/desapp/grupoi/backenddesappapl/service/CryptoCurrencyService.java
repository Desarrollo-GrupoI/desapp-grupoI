package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;

@Service
public class CryptoCurrencyService {
	private String urlBase = "https://api1.binance.com/api/v3/ticker/price?symbol=";
	private RestTemplate template = new RestTemplate();
	private LocalDateTime date;
	private CryptoCurrency cryptoCurrency;
	
	public CryptoCurrencyService() {}
	
	
	public CryptoCurrency getCryptoBySymbol(String cryptoSymbol) {
		CryptoSymbol symbol = new ValidCryptoSymbol(cryptoSymbol).getCryptoSymbol();
		if (cryptoCurrency == null || Duration.between(date, LocalDateTime.now()).toMinutes() >= 10) {
			cryptoCurrency = template.getForObject(urlBase + symbol, CryptoCurrency.class);
			date = LocalDateTime.now();
		}
		
		return cryptoCurrency;
	}

	@Transactional
	public List<CryptoCurrency> getCryptoSymbols() {
		List<CryptoCurrency> cryptoCurrencies = new ArrayList<CryptoCurrency>();
		
		for(CryptoSymbol symbol : CryptoSymbol.values())
			cryptoCurrencies.add(template.getForObject(urlBase + symbol, CryptoCurrency.class));
		
		return cryptoCurrencies;			
	}
}
