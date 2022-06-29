package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

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

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.IntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.IntentionOperationDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.IntentionService;

@RestController
@RequestMapping("/intention")
public class IntentionRestController {
	@Autowired
	private IntentionService intentionService;
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@PostMapping(path = "/register")
	public ResponseEntity<String> register(@Valid @RequestBody RegisterIntentionDTO intention) {
		logger.log(Level.INFO, "Starting - registering the intention '" + intention + "'");
		this.intentionService.saveIntention(intention);
		logger.log(Level.INFO, "Ending - registering the intention");
		
		return ResponseEntity.ok().body("The intention was registered");
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<IntentionDTO>> findAll() {
		logger.log(Level.INFO, "Starting - obtaining all the intentions");
		List<IntentionDTO> intentions = intentionService.findAll();
		logger.log(Level.INFO, "Ending - obtaining all the intentions");
		
		return ResponseEntity.ok().body(intentions);
	}
	
	@GetMapping(path = "/get/{operation}")
	public ResponseEntity<List<IntentionOperationDTO>> findAllByOperation(@PathVariable String operation) {
		logger.log(Level.INFO, "Starting - obtaining all the intentions with the operation '" + operation + "'");
		List<IntentionOperationDTO> intentions = intentionService.findAllByOperation(operation);
		logger.log(Level.INFO, "Ending - obtaining all the intentions");
		
		return ResponseEntity.ok().body(intentions);
	}
}
