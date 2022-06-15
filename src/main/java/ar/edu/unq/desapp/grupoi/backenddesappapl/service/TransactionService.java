package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.IntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterTransactionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Intention;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Transaction;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.TransactionState;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFound;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.DateService;
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
	@Autowired
	private DateService dateService;
	
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
					operation,
					this.dateService.getDate()
					);

		this.intentionRepository.save(intention);
	}
	
	@Transactional
	public void saveTransaction(RegisterTransactionDTO transactionDTO) {
		User user = this.userService.findById(transactionDTO.getUserId());
		Intention intention = this.findIntentionById(transactionDTO.getIntentionId());
		
		Transaction transaction = new Transaction(intention, user, TransactionState.PENDING);

		this.transactionRepository.save(transaction);
	}
	
	public List<IntentionDTO> findAllIntention() {
		List<Intention> intentions = (List<Intention>)this.intentionRepository.findAll();
		List<IntentionDTO> intentionsDTO = new ArrayList<IntentionDTO>();
		for(Intention intention : intentions) {
			intentionsDTO.add(
					new IntentionDTO(
							intention.getDate(), 
							intention.getCryptoSymbol(), 
							intention.getCryptoAmount(),
							intention.getPrice(),
							intention.getPesosArgAmount(),
							intention.getUser().getName(),
							intention.getUser().getSurname(),
							"0",
							"30"
							)
					);
		}
		return intentionsDTO;
	}
	
	public Intention findIntentionById(Integer intentionId) {
		try {
			return this.intentionRepository.findById(intentionId).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFound("The intention was not found");
		}
	}
}
