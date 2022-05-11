package ar.edu.unq.desapp.grupoi.backenddesappapl.controller;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.UserService;
import ar.edu.unq.desapp.grupoi.backenddesappapl.webservice.UserRestController;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Mock
    private UserService userService;
	
	@InjectMocks
	private UserRestController userController;
	
	
	@Test
    public void findAll() {
    	UserDTO userOne = new UserDTO("nameTest","surnameTest",1,"");
    	UserDTO userTwo = new UserDTO("nameTest2","surnameTest2",2,"");
    	
    	List<UserDTO> userList = new ArrayList<>();
    	userList.add(userOne);
    	userList.add(userTwo);
    	
    	when(userService.findAll()).thenReturn(userList);
    	
    	List<UserDTO> userDTOList = userController.findAll();
    	
    	Assertions.assertEquals(2, userDTOList.size());
    	verify(userService, atLeastOnce()).findAll();
    }
	
	
	@Test
    public void findById() {
    	User userOne = new User("nameTest","surnameTest","test@gmail.com","addressTest","123Test#");
    	
    	when(userService.findById("test@gmail.com")).thenReturn(userOne);
    	
    	ResponseEntity<User> actualUser = userController.findById("test@gmail.com");
    	
    	Assertions.assertEquals(actualUser.getBody().getEmail(), userOne.getEmail());
    	verify(userService, atLeastOnce()).findById("test@gmail.com");
    	
    }

}
