package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Intention;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidOperation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.IntentionRepository;

@ExtendWith(MockitoExtension.class)
public class IntentionServiceTest {
	
	@InjectMocks
	private TransactionService intentionService;
	
	@Mock
	private IntentionRepository intentionRepository;
	
	@InjectMocks
	private UserService userService;
	
	@InjectMocks
	private DolarService dolarService;
	
	@Test
    public void saveIntention() {
		
		RegisterIntentionDTO intentionDTO =  new RegisterIntentionDTO("MATICUSDT","1,5","10","nacho@gmail.com","SELL");
		CryptoSymbol cryptoSymbol = new ValidCryptoSymbol(intentionDTO.getCryptoSymbol()).getCryptoSymbol();
		Operation operation = new ValidOperation(intentionDTO.getOperation()).getOperation();
		Float dolarOficialSellValue = dolarService.getDolarOficialSellValue();
		
		Intention intention = new Intention(cryptoSymbol, 
											intentionDTO.getCryptoAmount(), 
											intentionDTO.getPrice(),
											intentionDTO.getPrice() * dolarOficialSellValue,
											userService.findById(intentionDTO.getUserEmail()), 
											operation);
		
		when(intentionRepository.save(any())).thenReturn(intention);
		
		intentionService.saveIntention(intentionDTO);
		
        Assertions.assertEquals(intention.getCryptoSymbol(), intentionDTO.getCryptoSymbol());
        verify(intentionRepository, atLeastOnce()).save(any());
    }

}
