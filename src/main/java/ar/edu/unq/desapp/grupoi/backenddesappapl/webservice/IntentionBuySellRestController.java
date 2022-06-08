package ar.edu.unq.desapp.grupoi.backenddesappapl.webservice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.service.IntentionBuySellService;

@RestController
@RequestMapping("/intention")
public class IntentionBuySellRestController {
	@Autowired
	private IntentionBuySellService intentionService;
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterIntentionDTO intention) {
		intentionService.save(intention);
		return ResponseEntity.ok().body("The intention was registered");
	}
}
