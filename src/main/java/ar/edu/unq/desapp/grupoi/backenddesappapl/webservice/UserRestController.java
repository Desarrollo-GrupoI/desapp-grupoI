package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.DatePeriodDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterUserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserCredentialsDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.UserVolumeDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.User;
import ar.edu.unq.desapp.grupoi.backenddesappapl.security.JwtUtils;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;
    
	private Logger logger = LogManager.getLogger(this.getClass());
    
	@PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserCredentialsDTO userDTO) {
		HashMap<String, String> map = new HashMap<String, String>();	
        userService.login(userDTO);     
        String token = jwtUtils.createToken(userDTO.email());
        map.put("token", token);
        
        return ResponseEntity.ok(map);
    }
	
	@PostMapping(path = "/register")
	public ResponseEntity<String> register(@Valid @RequestBody RegisterUserDTO userDTO) {
		logger.log(Level.INFO, "Starting - registering the user '" + userDTO + "'");
		userService.save(userDTO);
		logger.log(Level.INFO, "Ending - registering the user");
		
		return ResponseEntity.ok().body("The user was registered");
	}
	
	@GetMapping(path = "/get/{userEmail}")
	public ResponseEntity<User> findById(@PathVariable String userEmail) {
		logger.log(Level.INFO, "Starting - searching the user with the email '" + userEmail + "'");
		User user = userService.findById(userEmail);
		logger.log(Level.INFO, "Ending - searching the user with the email");
		
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<UserDTO>> findAll() {
		logger.log(Level.INFO, "Starting - obtaining all the users");
		List<UserDTO> users = userService.findAll();
		logger.log(Level.INFO, "Ending - obtaining all the users");
		
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(path = "/volume/{userEmail}")
	public ResponseEntity<UserVolumeDTO> findVolumeById(@PathVariable String userEmail, @Valid @RequestBody DatePeriodDTO dateDTO) {
		logger.log(Level.INFO, "Starting - obtaining the volume of the user with the email '" + userEmail + "', between the dates " + dateDTO);
		UserVolumeDTO userVolume = userService.findVolumeById(userEmail, dateDTO);
		logger.log(Level.INFO, "Starting - obtaining the user volume");
		
		return ResponseEntity.ok().body(userVolume);
	}
}
