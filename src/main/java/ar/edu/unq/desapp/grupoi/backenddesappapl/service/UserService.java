package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Cvu;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.CvuRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private CvuRepository cvuRepository;
	@Autowired
	private UserRepository userRepository;
				
	@Transactional
	public User save(RegisterUserDTO userDTO) {
		Cvu cvu = this.cvuRepository.save(new Cvu());
		User user = new User(
				userDTO.getName(),
				userDTO.getSurname(),
				userDTO.getEmail(),
				userDTO.getAddress(),
				userDTO.getPassword()
				);

		user.initializeCvu(cvu.getNumber());
		user.initializeWalletAddress(cvu.getNumber());
		
		this.cvuRepository.delete(cvu);
	
		return this.userRepository.save(user);
	}
	
	public List<UserDTO> findAll() {
		List<User> users =  (List<User>) this.userRepository.findAll();
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
	
	public void addOperation(String userEmailA, String userEmailB, Integer points) {
		this.userRepository.addOperation(userEmailA, userEmailB, points);
	}
	
	public void updateUserReputation(String userEmail, String reputationPointsOperation) {
		this.userRepository.updateUserReputationPoints(userEmail, reputationPointsOperation);
	}
	
	public boolean existsById(String email) {
		return this.userRepository.findById(email).isPresent();
	}
}
