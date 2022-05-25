package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;

@Service
public class CryptoCurrencyService {
	
	RestTemplate template = new RestTemplate();
	
	public CryptoCurrency getCryptoBySymbol(String cryptoSymbol) {		
		String response = "https://api1.binance.com/api/v3/ticker/price?symbol=" + cryptoSymbol;
		CryptoCurrency cryptoTemplate = template.getForObject(response, CryptoCurrency.class);
		return cryptoTemplate;			
	}

}
