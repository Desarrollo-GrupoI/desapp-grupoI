package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
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
}
