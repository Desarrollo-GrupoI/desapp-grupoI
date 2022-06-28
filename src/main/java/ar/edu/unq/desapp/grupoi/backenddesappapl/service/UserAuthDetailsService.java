package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.AuthUser;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.UserRepository;

@Service
public class UserAuthDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	try {
    		User user = userRepository.findById(email).get();
    		return new AuthUser(user.getEmail(), user.getPassword());
    	} catch(NoSuchElementException e) {       
    		throw new EntityNotFoundException("The email or password is invalid"); 
        }       
    }
}
