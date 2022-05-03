package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.Validator;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User save(RegisterUserDTO userDTO) {	
		User user = new User(userDTO.getName(),
				userDTO.getSurname(),
				userDTO.getEmail(),
				userDTO.getAddress(),
				userDTO.getPassword(),
				userDTO.getCvu(),
				userDTO.getWalletAddress());
		
		//Validator.validateUser(userDTO);
				
		return this.userRepository.save(user);
	}
	
	
	public List<UserDTO> findAll() {
		List<User> users =  (List<User>)userRepository.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User user: users) {
			usersDTO.add(new UserDTO(user.getName(),user.getSurname(),user.getOperations(),user.getReputation()));
		};
		return usersDTO;
	}
	
	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);			
	}
	
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}
