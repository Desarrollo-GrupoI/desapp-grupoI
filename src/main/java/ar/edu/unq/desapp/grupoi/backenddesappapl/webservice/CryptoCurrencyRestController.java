package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.CryptoCurrencyService;

@RestController
@RequestMapping("/crypto")
public class CryptoCurrencyRestController {

	@Autowired
	private CryptoCurrencyService cryptoService;
	
	@GetMapping(path = "/get/{cryptoSymbol}")
	public ResponseEntity<CryptoCurrency> getCryptoBySymbol(@PathVariable String cryptoSymbol) {	
		CryptoCurrency crypto = cryptoService.getCryptoBySymbol(cryptoSymbol);
		return ResponseEntity.ok().body(crypto);
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<CryptoCurrency>> getAllCryptoSymbols() {	
		List<CryptoCurrency> cryptos = cryptoService.getCryptoSymbols();
		return ResponseEntity.ok().body(cryptos);
	}
}
