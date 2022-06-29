package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.CryptoActiveDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.DatePeriodDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserCredentialsDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserVolumeDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.CryptoSymbol;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Cvu;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Transaction;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.InvalidArgumentsException;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.ValidDate;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.CvuRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private CvuRepository cvuRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private DollarService dollarService;
	@Autowired
	private CryptoCurrencyService cryptoCurrencyService;
    @Autowired
    private PasswordEncoder passwordEncoder;    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Transactional
    public void login(UserCredentialsDTO userDTO) {
    	UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDTO.email(), userDTO.password());
    	try {
    		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    	} catch (AuthenticationException e) {
    		throw new InvalidArgumentsException("The email or password is invalid");
    	}
    }
	
	@Transactional
	public User save(RegisterUserDTO userDTO) {
		String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
		Cvu cvu = this.cvuRepository.save(new Cvu());
		User user = new User(
				userDTO.getName(),
				userDTO.getSurname(),
				userDTO.getEmail(),
				userDTO.getAddress(),
				encodedPassword
				);

		user.initializeCvu(cvu.getNumber());
		user.initializeWalletAddress(cvu.getNumber());
		
		this.cvuRepository.delete(cvu);
	
		return this.userRepository.save(user);
	}
	
	public List<UserDTO> findAll() {
		List<User> users = (List<User>) this.userRepository.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(User user: users) {
			usersDTO.add(new UserDTO(user.getName(), user.getSurname(), user.getOperations(), user.getReputation()));
		};
		
		return usersDTO;
	}

	public User findById(String email) {
		try {
			return this.userRepository.findById(email).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFoundException("The user was not found");
		}
	}  
	
	public void deleteById(String email) {
		this.userRepository.deleteById(email);
	}
	
	public void addOperation(String userEmailA, String userEmailB) {
		this.userRepository.addOperation(userEmailA, userEmailB);
	}
	
	public void updateReputationPoints(String userEmail, Integer reputationPointsOperation, Boolean isAdd) {
		if(isAdd)
			this.userRepository.addReputationPoints(userEmail, reputationPointsOperation);
		else
			this.userRepository.removeReputationPoints(userEmail, reputationPointsOperation);
	}
	
	public void updateReputationPoints(String userEmailA, String userEmailB, Integer reputationPointsOperation, Boolean isAdd) {
		if(isAdd)
			this.userRepository.addReputationPoints(userEmailA, userEmailB, reputationPointsOperation);
		else
			this.userRepository.removeReputationPoints(userEmailA, userEmailB, reputationPointsOperation);
	}
	
	public boolean existsById(String email) {
		return this.userRepository.findById(email).isPresent();
	}
	
	public UserVolumeDTO findVolumeById(String email, DatePeriodDTO dateDTO) {
		LocalDateTime dateFrom = new ValidDate(dateDTO.getDateFrom()).getDate();
		LocalDateTime dateTo = new ValidDate(dateDTO.getDateTo()).getDate(); 
		
		User user = this.findById(email);
		Float dollarPrice = this.dollarService.getDolarOficialSellValue();
		
		List<Transaction> doneTansactions = this.transactionService.findDoneTransactions(email, dateFrom, dateTo);
		
		Map<CryptoSymbol, Float> cryptoSymbolAmount = new HashMap<CryptoSymbol, Float>();
		Map<CryptoSymbol, Float> cryptoSymbolOperatedAmount = new HashMap<CryptoSymbol, Float>();
		for(Transaction transaction : doneTansactions) {
			Float cryptoAmount = cryptoSymbolAmount.getOrDefault(transaction.getCryptoSymbol(), 0f);
			Float cryptoOperatedAmount = cryptoSymbolOperatedAmount.getOrDefault(transaction.getCryptoSymbol(), 0f);
			
			if(StringUtils.equals(transaction.getUser().getEmail(), email))
				cryptoAmount = transaction.getTransactionIntention().getOperation() == Operation.BUY ? cryptoAmount - transaction.getCryptoAmount() : cryptoAmount + transaction.getCryptoAmount();
			else if(StringUtils.equals(transaction.getTransactionIntention().getUser().getEmail(), email))
				cryptoAmount = transaction.getTransactionIntention().getOperation() == Operation.BUY ? cryptoAmount + transaction.getCryptoAmount() : cryptoAmount - transaction.getCryptoAmount();
			
			cryptoSymbolAmount.put(transaction.getCryptoSymbol(), cryptoAmount);
			cryptoSymbolOperatedAmount.put(transaction.getCryptoSymbol(), cryptoOperatedAmount + transaction.getCryptoAmount());
		}
		
		List<CryptoActiveDTO> cryptoActives = new ArrayList<CryptoActiveDTO>();
		for(CryptoSymbol cryptoSymbol : cryptoSymbolAmount.keySet()) {
			Float cryptoAmount = cryptoSymbolAmount.get(cryptoSymbol);
			Float cryptoDollarPrice = this.cryptoCurrencyService.getCryptoBySymbol(cryptoSymbol).getPrice();
			Float cryptoPesosPrice = cryptoDollarPrice * dollarPrice;
			
			cryptoActives.add(new CryptoActiveDTO(cryptoSymbol, cryptoAmount, cryptoDollarPrice, cryptoPesosPrice));
		}
		
		Float totalDollarPrice = 0f;
		for(CryptoActiveDTO cryptoActive : cryptoActives)
			totalDollarPrice += cryptoSymbolOperatedAmount.get(cryptoActive.getCryptoSymbol()) * cryptoActive.getPrice();
		
		return new UserVolumeDTO(user, LocalDateTime.now(), totalDollarPrice, totalDollarPrice * dollarPrice, cryptoActives);
	}
}
