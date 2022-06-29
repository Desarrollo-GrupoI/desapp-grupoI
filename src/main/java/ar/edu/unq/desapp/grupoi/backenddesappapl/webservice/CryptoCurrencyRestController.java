package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.CryptoCotizationDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoCurrency;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.CryptoCurrencyService;

@RestController
@RequestMapping("/crypto")
public class CryptoCurrencyRestController {
	@Autowired
	private CryptoCurrencyService cryptoService;
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@GetMapping(path = "/get/{cryptoSymbol}")
	public ResponseEntity<CryptoCurrency> getCryptoBySymbol(@PathVariable String cryptoSymbol) {
		logger.log(Level.INFO, "Starting - obtaining the crypto symbol '" + cryptoSymbol + "'");
		CryptoCurrency crypto = cryptoService.getCryptoBySymbol(cryptoSymbol);
		logger.log(Level.INFO, "Ending - obtaining the crypto symbol");
		
		return ResponseEntity.ok().body(crypto);
	} 
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<CryptoCurrency>> getAllCryptoSymbols() {
		logger.log(Level.INFO, "Starting - obtaining all the crypto symbols");
		List<CryptoCurrency> cryptos = cryptoService.getCryptoSymbols();
		logger.log(Level.INFO, "Ending - obtaining all the crypto symbols");
		
		return ResponseEntity.ok().body(cryptos);
	}
	
	@GetMapping(path = "/cotizationPerDay")
	public ResponseEntity<Map<LocalDateTime,List<CryptoCurrency>>> cotizationCryptoPerDay() {
		Map<LocalDateTime,List<CryptoCurrency>> cryptoHistory = cryptoService.cotizationCryptoPerDay();
		return ResponseEntity.ok().body(cryptos);
	}
}
