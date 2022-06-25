package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.CvuRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.IntentionRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class IntentionServiceTest {
	
	@InjectMocks
	private IntentionService intentionService;
	
	@Mock
	private IntentionRepository intentionRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private CvuRepository cvuRepository;
	
	@Mock
	private UserService userService;
	
	@Mock
	private DollarService dolarService;
	 
	@Mock
	private DateService dateService;
	
	@Test
    public void saveIntention() {

		RegisterIntentionDTO intentionDTO =  new RegisterIntentionDTO("MATICUSDT","1,5","10","test@gmail.com","SELL");
		CryptoSymbol cryptoSymbol = new ValidCryptoSymbol(intentionDTO.getCryptoSymbol()).getCryptoSymbol();
		Operation operation = new ValidOperation(intentionDTO.getOperation()).getOperation();
		
		when(dolarService.getDolarOficialSellValue()).thenReturn((float)120);
		Float dolarOficialSellValue = dolarService.getDolarOficialSellValue();
		
		Intention intention = new Intention(
				cryptoSymbol, 
				intentionDTO.getCryptoAmount(), 
				intentionDTO.getPrice(),
				intentionDTO.getPrice() * dolarOficialSellValue,
				userService.findById("test@gmail.com"), 
				operation,
				dateService.getDate()
				);
		
		when(intentionRepository.save(any())).thenReturn(intention);
		
		intentionService.saveIntention(intentionDTO);
		
        Assertions.assertEquals(intention.getCryptoSymbol().name(), intentionDTO.getCryptoSymbol());
        verify(intentionRepository, atLeastOnce()).save(any());
    }
	 
	
	@Test
	public void findAllIntentions() {
		CryptoSymbol cryptoSymbol1 = new ValidCryptoSymbol("MATICUSDT").getCryptoSymbol();
		CryptoSymbol cryptoSymbol2 = new ValidCryptoSymbol("NEOUSDT").getCryptoSymbol();
		Operation operation = new ValidOperation("BUY").getOperation();
		User user = new User("nameTest","surnameTest","test@gmail.com","addressTest","123Test#");
		LocalDateTime date = LocalDateTime.now();
		Float cryptoAmount = Float.parseFloat("2");
		Float cryptoPrice = Float.parseFloat("10");
		Float cryptoPesosArg = Float.parseFloat("140");
		
		Intention intention1 = new Intention(cryptoSymbol1,cryptoAmount,cryptoPrice,cryptoPesosArg,user,operation,date);
		Intention intention2 = new Intention(cryptoSymbol2,cryptoAmount,cryptoPrice,cryptoPesosArg,user,operation,date);
		
		List<Intention> intentions = new ArrayList<Intention>();
		intentions.add(intention1);
		intentions.add(intention2);
		
		when(intentionRepository.findAll()).thenReturn(intentions);
		
		List<IntentionDTO> intentionsDTO = intentionService.findAll();
		Assertions.assertEquals(2, intentionsDTO.size());
		verify(intentionRepository, atLeastOnce()).findAll();
		
	}
	
	
	@Test
	public void findIntentionById() {
		EntityNotFoundException exception = Assertions.assertThrows(EntityNotFoundException.class, () -> {
   		 intentionService.findById(32);
   	 });
   	 
   	 Assertions.assertEquals("The intention was not found", exception.getMessage());
   }
	
	
	@Test
	public void findAllByOperation() {
		CryptoSymbol cryptoSymbol1 = new ValidCryptoSymbol("MATICUSDT").getCryptoSymbol();
		Operation operationBuy = new ValidOperation("BUY").getOperation();
		Operation operationSell = new ValidOperation("SELL").getOperation();
		User user = new User("nameTest","surnameTest","test@gmail.com","addressTest","123Test#");
		LocalDateTime date = LocalDateTime.now();
		Float cryptoAmount = Float.parseFloat("2");
		Float cryptoPrice = Float.parseFloat("10");
		Float cryptoPesosArg = Float.parseFloat("140");
		
		Intention intention1 = new Intention(cryptoSymbol1,cryptoAmount,cryptoPrice,cryptoPesosArg,user,operationBuy,date);
		Intention intention2 = new Intention(cryptoSymbol1,cryptoAmount,cryptoPrice,cryptoPesosArg,user,operationBuy,date);
		Intention intention3 = new Intention(cryptoSymbol1,cryptoAmount,cryptoPrice,cryptoPesosArg,user,operationSell,date);
		
		List<Intention> intentionsBuy = new ArrayList<Intention>();
		intentionsBuy.add(intention1);
		intentionsBuy.add(intention2);
		
		List<Intention> intentionsSell = new ArrayList<Intention>();
		intentionsSell.add(intention3);
		
		when(intentionRepository.findAllByOperation(operationBuy)).thenReturn(intentionsBuy);
		when(intentionRepository.findAllByOperation(operationSell)).thenReturn(intentionsSell);
		
		List<IntentionOperationDTO> intentionsBuyDTO = intentionService.findAllByOperation("BUY");
		List<IntentionOperationDTO> intentionsSellDTO = intentionService.findAllByOperation("SELL");
		Assertions.assertEquals(2, intentionsBuyDTO.size());
		Assertions.assertEquals(1, intentionsSellDTO.size());
		
		verify(intentionRepository, atLeastOnce()).findAllByOperation(operationBuy);
	}
	
	
}
