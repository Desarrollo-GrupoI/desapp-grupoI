package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Cvu;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.UserNotFound;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.CvuRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CvuRepository cvuRepository;
	
	public User save(RegisterUserDTO userDTO) {		
		User user = new User(
				userDTO.getName(),
				userDTO.getSurname(),
				userDTO.getEmail(),
				userDTO.getAddress(),
				userDTO.getPassword()
				);
				
		return this.userRepository.save(user);
	}
	
	public List<UserDTO> findAll() {
		List<User> users =  (List<User>) userRepository.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User user: users) {
			usersDTO.add(
					new UserDTO(
							user.getName(),
							user.getSurname(),
							0,
							""
							)
					);
		};
		
		return usersDTO;
	}
	
	public User findById(String email) {
		try {
			return userRepository.findById(email).get();			
		} catch(NoSuchElementException e) {
			throw new UserNotFound("The user was not found");
		}
	}
	
	public void deleteById(String email) {
		userRepository.deleteById(email);
	}
}
