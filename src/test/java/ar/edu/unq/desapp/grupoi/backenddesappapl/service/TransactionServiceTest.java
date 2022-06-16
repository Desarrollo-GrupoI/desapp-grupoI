package ar.edu.unq.desapp.grupoi.backenddesappapl.service;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterTransactionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Intention;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidCryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidOperation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.IntentionRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.TransactionRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.UserRepository;


@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
	
	@InjectMocks
	private TransactionService transactionService;
	
	@Mock
	private IntentionService intentionService;
	
	@Mock
	private IntentionRepository intentionRepository;
	
	@Mock
	private TransactionRepository transactionRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private UserService userService;
	
	
	@Test
    public void saveTransaction() {
		RegisterTransactionDTO transactionDTO = new RegisterTransactionDTO(1,"test@gmail.com");
		User user = new User("nameTest","surnameTest","test@gmail.com","addressTest","123Test#");
		CryptoSymbol cryptoSymbol = new ValidCryptoSymbol("MATICUSDT").getCryptoSymbol();
		Operation operation = new ValidOperation("BUY").getOperation();
		LocalDateTime date = LocalDateTime.now();
		Float cryptoAmount = Float.parseFloat("2");
		Float cryptoPrice = Float.parseFloat("10");
		Float cryptoPesosArg = Float.parseFloat("140");
		Intention intention = new Intention(cryptoSymbol,cryptoAmount,cryptoPrice,cryptoPesosArg,user,operation,date);
		
		when(intentionService.findById(1)).thenReturn(intention);
		
		transactionService.saveTransaction(transactionDTO);
		
		verify(transactionRepository, atLeastOnce()).save(any());
		
	}

}
