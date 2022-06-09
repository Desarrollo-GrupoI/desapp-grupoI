package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.NoSuchElementException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Intention;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Transaction;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFound;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidOperation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.IntentionRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private IntentionRepository intentionRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DolarService dolarService;
	
	@Transactional
	public void saveIntention(RegisterIntentionDTO intentionDTO) {
		CryptoSymbol cryptoSymbol = new ValidCryptoSymbol(intentionDTO.getCryptoSymbol()).getCryptoSymbol();
		Operation operation = new ValidOperation(intentionDTO.getOperation()).getOperation();
		Float dolarOficialSellValue = dolarService.getDolarOficialSellValue();
		
		Intention intention = 
				new Intention(
					cryptoSymbol,
					intentionDTO.getCryptoAmount(),
					intentionDTO.getPrice(),
					intentionDTO.getPrice() * dolarOficialSellValue,
					userService.findById(intentionDTO.getUserEmail()),
					operation
					);

		this.intentionRepository.save(intention);
	}
	
	@Transactional
	public void saveTransaction(String userEmail, Integer intentionId) {
		User user = this.userService.findById(userEmail);
		Intention intention = this.findIntentionById(intentionId);
		
		Transaction transaction = new Transaction(intention, user);

		this.transactionRepository.save(transaction);
	}
	
	public Intention findIntentionById(Integer intentionId) {
		try {
			return this.intentionRepository.findById(intentionId).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFound("The intention was not found");
		}
	}
}
