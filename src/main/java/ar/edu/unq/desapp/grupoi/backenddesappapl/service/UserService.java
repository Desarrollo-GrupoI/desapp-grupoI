package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils.Validator;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		Validator.validateUser(user);
		return this.userRepository.save(user);
	}
}
