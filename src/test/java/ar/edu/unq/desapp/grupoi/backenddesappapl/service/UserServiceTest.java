package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.ArgumentMatchers.any;
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

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Cvu;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.UserNotFound;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.CvuRepository;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private CvuRepository cvuRepository;
	@Mock
    private UserRepository userRepository;		
	@InjectMocks
    private UserService userService;
      
    @Test
    public void saveUser() {
		RegisterUserDTO userDTO =  new RegisterUserDTO("nameTest","surnameTest","test@gmail.com","addressTest","123Test#");
		
		User user = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getEmail(), userDTO.getAddress(), userDTO.getPassword(), "0000000000000000000001", "00000001");
		Cvu cvu = new Cvu();
		cvu.setNumber(new Integer(1));
		
		when(userRepository.save(any())).thenReturn(user);
		when(cvuRepository.save(any())).thenReturn(cvu);
		
		User actualUser = userService.save(userDTO);
		
        Assertions.assertEquals(user.getEmail(), actualUser.getEmail());
        verify(userRepository, atLeastOnce()).save(any());
        verify(cvuRepository, atLeastOnce()).save(any());
    }
    
    @Test
    public void findAll() {
    	User userOne = new User("nameTest","surnameTest","test@gmail.com","addressTest","123Test#");
    	User userTwo = new User("nameTest2","surnameTest2","testtwo@gmail.com","addressTest2","123Test#2");
    	
    	List<User> userList = new ArrayList<>();
    	userList.add(userOne);
    	userList.add(userTwo);
    	
    	when(userRepository.findAll()).thenReturn(userList);
    	
    	List<UserDTO> userDTOList = userService.findAll();
    	
    	Assertions.assertEquals(2, userDTOList.size());
    	verify(userRepository, atLeastOnce()).findAll();
    } 
    
    
    
    @Test
    public void findById() {
    	User userOne = new User("nameTest","surnameTest","test@gmail.com","addressTest","123Test#");
    	
    	when(userRepository.findById("test@gmail.com")).thenReturn(java.util.Optional.ofNullable(userOne));
    	
    	User actualUser = userService.findById("test@gmail.com");
    	
    	Assertions.assertEquals(actualUser, userOne);
    	verify(userRepository, atLeastOnce()).findById("test@gmail.com");
    	
    }
    
    @Test
    public void userDoesNotExist() {
    	
    	UserNotFound exception = Assertions.assertThrows(UserNotFound.class, () -> {
    		 userService.findById("emailTest@gmail.com");
    	 });
    	 
    	 Assertions.assertEquals("The user was not found", exception.getMessage());
    }
    
    
    @Test
    public void deleteById() {
    	userService.deleteById("mail@gmail.com");
    	verify(userRepository, atLeastOnce()).deleteById("mail@gmail.com");
    }
    
    

}
