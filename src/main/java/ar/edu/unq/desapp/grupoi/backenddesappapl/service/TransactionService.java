package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.time.Duration;
import java.time.Period;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterTransactionActionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterTransactionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Intention;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Transaction;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.TransactionState;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.InvalidArgumentsException;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.DateService;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private DateService dateService;
	@Autowired
	private IntentionService intentionService;
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Transactional
	public void saveTransaction(RegisterTransactionDTO transactionDTO) {
		User user = this.userService.findById(transactionDTO.getUserEmail());
		Intention intention = this.intentionService.findById(transactionDTO.getIntentionId());
		
		if(StringUtils.equals(transactionDTO.getUserEmail(), intention.getUser().getEmail()))
			throw new InvalidArgumentsException("You cannot make a transaction with yourself");
		
		Transaction transaction = new Transaction(intention, user, TransactionState.PENDING);

		this.transactionRepository.save(transaction);
	}

	@Transactional
	public void acceptTransaction(RegisterTransactionActionDTO transactionDTO) {
		if(!this.userService.existsById(transactionDTO.getUserEmail()))
			throw new EntityNotFoundException("The user was not found");
		
		Intention intention = this.intentionService.findById(transactionDTO.getIntentionId());
		Transaction transaction = this.findById(transactionDTO.getTransactionId());
		
		if(!StringUtils.equals(transactionDTO.getUserEmail(), intention.getUser().getEmail()))
			throw new InvalidArgumentsException("You cannot accept this transaction");
		
		//chequear cancelacion de precio para cancelar por sistema
		int points = Duration.between(transaction.getDate(), dateService.getDate()).toMinutes() <= 30 ? 10 : 5;
		
		this.userService.addOperation(intention.getUser().getEmail(), transaction.getUser().getEmail(), points);
	}

	@Transactional
	public void cancelTransaction(RegisterTransactionActionDTO transactionDTO) {
		// TODO Auto-generated method stub
		
	}
	
	public Transaction findById(Integer transactionId) {
		try {
			return this.transactionRepository.findById(transactionId).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFoundException("The transaction was not found");
		}
	}
}
