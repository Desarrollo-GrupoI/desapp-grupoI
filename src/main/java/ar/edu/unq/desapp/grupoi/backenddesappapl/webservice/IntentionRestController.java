package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

import java.util.List;

import javax.validation.Valid;

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
	
	@PostMapping(path = "/register")
	public ResponseEntity<String> register(@Valid @RequestBody RegisterIntentionDTO intention) {
		this.intentionService.saveIntention(intention);
		return ResponseEntity.ok().body("The intention was registered");
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<IntentionDTO>> findAll() {
		List<IntentionDTO> intentions = intentionService.findAll();
		return ResponseEntity.ok().body(intentions);
	}
	
	@GetMapping(path = "/get/{operation}")
	public ResponseEntity<List<IntentionOperationDTO>> findAllByOperation(@PathVariable String operation) {
		List<IntentionOperationDTO> intentions = intentionService.findAllByOperation(operation);
		return ResponseEntity.ok().body(intentions);
	}
}
