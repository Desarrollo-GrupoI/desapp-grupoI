package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDTO userDTO) {
		userService.save(userDTO);
		return ResponseEntity.ok().body("The user was registered");
	}
	
	@GetMapping(path = "/get/{email}")
	public ResponseEntity<Optional<User>> findByEmail(@RequestParam String email) {
		Optional<User> user = userService.findByEmail(email);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(path = "/getAll")
	public List<UserDTO> findAll() {
		return userService.findAll();
	}
}
