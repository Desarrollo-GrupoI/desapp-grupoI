package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.IntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.IntentionOperationDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Intention;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidOperation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.IntentionRepository;

@Service
public class IntentionService {
	@Autowired
	private IntentionRepository intentionRepository;
	@Autowired
	private DollarService dolarService;
	@Autowired
	private UserService userService;
	@Autowired
	private DateService dateService;
	
	@Transactional
	public void saveIntention(RegisterIntentionDTO intentionDTO) {
		User user = this.userService.findById(intentionDTO.getUserEmail());
		CryptoSymbol cryptoSymbol = new ValidCryptoSymbol(intentionDTO.getCryptoSymbol()).getCryptoSymbol();
		Operation operation = new ValidOperation(intentionDTO.getOperation()).getOperation();
		Float dolarOficialSellValue = dolarService.getDolarOficialSellValue();
		
		Intention intention = 
				new Intention(
					cryptoSymbol,
					intentionDTO.getCryptoAmount(),
					intentionDTO.getPrice(),
					intentionDTO.getPrice() * dolarOficialSellValue,
					user,
					operation,
					this.dateService.getDate()
					);

		this.intentionRepository.save(intention);
	} 
	
	public List<IntentionDTO> findAll() {
		List<Intention> intentions = (List<Intention>) this.intentionRepository.findAll();
		List<IntentionDTO> intentionsDTO = new ArrayList<IntentionDTO>();
		
		for(Intention intention : intentions) {
			intentionsDTO.add(
					new IntentionDTO(
							intention.getDate(), 
							intention.getCryptoSymbol(), 
							intention.getCryptoAmount(),
							intention.getPrice(),
							intention.getPesosArgAmount(),
							intention.getOperation(),
							intention.getUser().getName(),
							intention.getUser().getSurname(),
							intention.getUser().getOperations(),
							intention.getUser().getReputation()
							)
					);
		}
		
		return intentionsDTO;
	}
	
	public Intention findById(Integer intentionId) {
		try {
			return this.intentionRepository.findById(intentionId).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFoundException("The intention was not found");
		}
	}
	
	public List<IntentionOperationDTO> findAllByOperation(String operationName) {
		Operation operation = new ValidOperation(operationName).getOperation();
		List<Intention> intentions = (List<Intention>) this.intentionRepository.findAllByOperation(operation);
		List<IntentionOperationDTO> intentionsDTO = new ArrayList<IntentionOperationDTO>();
		for(Intention intention : intentions) {
			intentionsDTO.add(
					new IntentionOperationDTO(
							intention.getDate(), 
							intention.getCryptoSymbol(), 
							intention.getCryptoAmount(),
							intention.getPrice(),
							intention.getPesosArgAmount(),
							intention.getUser().getName(),
							intention.getUser().getSurname(),
							intention.getOperation()
							)
					);
		}
		
		return intentionsDTO;
	}
	
	public Boolean existsById(Integer intentionId) {
		return this.intentionRepository.findById(intentionId).isPresent();
	}
}
