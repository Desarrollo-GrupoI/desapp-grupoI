package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.IntentionBuySell;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidOperation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.IntentionBuySellRepository;

@Service
public class IntentionBuySellService {
	@Autowired
	private IntentionBuySellRepository intentionRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DolarService dolarService;
	
	@Transactional
	public void save(RegisterIntentionDTO intentionDTO) {
		CryptoSymbol cryptoSymbol = new ValidCryptoSymbol(intentionDTO.getCryptoSymbol()).getCryptoSymbol();
		Operation operation = new ValidOperation(intentionDTO.getOperation()).getOperation();
		Float dolarOficialSellValue = dolarService.getDolarOficialSellValue();
		
		IntentionBuySell intention = 
				new IntentionBuySell(
					cryptoSymbol,
					intentionDTO.getCryptoAmount(),
					intentionDTO.getPrice(),
					intentionDTO.getPrice() * dolarOficialSellValue,
					userService.findById(intentionDTO.getUserEmail()),
					operation
					);

		this.intentionRepository.save(intention);
	}
}
