package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.CryptoCurrencyService;

@RestController
@RequestMapping("/crypto")
public class CryptoCurrencyRestController {

	@Autowired
	private CryptoCurrencyService cryptoService;
	
	@GetMapping(path = "/{cryptoSymbol}")
	public ResponseEntity<CryptoCurrency> getCryptoBySymbol(@PathVariable CryptoSymbol cryptoSymbol) {	
		CryptoCurrency crypto = cryptoService.getCryptoBySymbol(cryptoSymbol.name());
		return ResponseEntity.ok().body(crypto);
	}
}
