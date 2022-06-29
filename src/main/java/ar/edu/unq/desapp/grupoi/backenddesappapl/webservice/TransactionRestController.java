package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.TransactionActionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.TransactionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.SystemException;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.IntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterTransactionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionRestController {
	@Autowired
	private TransactionService transactionService;
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@PostMapping(path = "/register")
	public ResponseEntity<String> register(@Valid @RequestBody RegisterTransactionDTO transaction) {
		logger.log(Level.INFO, "Starting - registering the transaction '" + transaction + "'");
		this.transactionService.saveTransaction(transaction);
		logger.log(Level.INFO, "Ending - registering the transaction '" + transaction + "'");
		
		return ResponseEntity.ok().body("The transaction was registered");
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<TransactionDTO>> findAllActives() {
		logger.log(Level.INFO, "Starting - obtaining all the active transactions ");
		List<TransactionDTO> transactions = transactionService.findAllActives();
		logger.log(Level.INFO, "Ending - obtaining all the active transactions ");
		
		return ResponseEntity.ok().body(transactions);
	}
	
	@PostMapping(path = "/accept")
	public ResponseEntity<String> accept(@Valid @RequestBody TransactionActionDTO transaction) {
		String responseMessage = "The transaction was accepted";
		try {
			logger.log(Level.INFO, "Starting - accepting the transaction '" + transaction + "'");
			this.transactionService.acceptTransaction(transaction);
			logger.log(Level.INFO, "Ending - accepting the transaction '" + transaction + "'");
		} catch(SystemException e) {
			responseMessage = e.getMessage();
		}
		
		return ResponseEntity.ok().body(responseMessage);
	}
	
	@PostMapping(path = "/cancel")
	public ResponseEntity<String> cancel(@Valid @RequestBody TransactionActionDTO transaction) {
		logger.log(Level.INFO, "Starting - canceling the transaction '" + transaction + "'");
		this.transactionService.cancelTransaction(transaction);
		logger.log(Level.INFO, "Ending - canceling the transaction '" + transaction + "'");
		
		return ResponseEntity.ok().body("The transaction was canceled");
	}
		
	
}
