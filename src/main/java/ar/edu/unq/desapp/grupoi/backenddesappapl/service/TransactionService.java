package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterTransactionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Intention;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Transaction;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.TransactionState;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private IntentionService intentionService;
	@Autowired
	private UserService userService;
	
	@Transactional
	public void saveTransaction(RegisterTransactionDTO transactionDTO) {
		User user = this.userService.findById(transactionDTO.getUserId());
		Intention intention = this.intentionService.findById(transactionDTO.getIntentionId());
		
		Transaction transaction = new Transaction(intention, user, TransactionState.PENDING);

		this.transactionRepository.save(transaction);
	}
	
	
}
