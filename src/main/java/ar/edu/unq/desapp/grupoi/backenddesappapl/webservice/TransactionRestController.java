package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.IntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterTransactionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionRestController {
	@Autowired
	private TransactionService transactionService;
	
	//Intention transaction
	@PostMapping(path = "/intention/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterIntentionDTO intention) {
		this.transactionService.saveIntention(intention);
		return ResponseEntity.ok().body("The intention was registered");
	}
	
	//Transaction
	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterTransactionDTO transaction) {
		this.transactionService.saveTransaction(transaction);
		return ResponseEntity.ok().body("The transaction was registered");
	} 
	
	//Intention transaction
	@GetMapping(path = "/intention/getAll")
	public List<IntentionDTO> findAll() {
		return transactionService.findAllIntention();
	}
}
