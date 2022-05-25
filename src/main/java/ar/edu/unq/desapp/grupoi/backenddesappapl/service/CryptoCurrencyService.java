package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;

@Service
public class CryptoCurrencyService {
	private String urlBase = "https://api1.binance.com/api/v3/ticker/price?symbol=";
	private RestTemplate template = new RestTemplate();
	
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
}
