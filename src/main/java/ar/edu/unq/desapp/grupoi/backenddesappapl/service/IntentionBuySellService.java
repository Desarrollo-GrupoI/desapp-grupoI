package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.IntentionBuySell;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.IntentionBuySellRepository;

@Service
public class IntentionBuySellService {
	
	@Autowired
	private IntentionBuySellRepository intentionRepository;
	
	private RestTemplate template = new RestTemplate();
	
	private String urlDolar = "https://www.dolarsi.com/api/api.php?type=dolar";
	
	@Autowired
	private UserService userService;
	
	
	@Transactional
	public void save(RegisterIntentionDTO intentionDTO) {
		
		String price = template.getForObject(urlDolar, String.class);
		Float asd = (float) 100.1;
		IntentionBuySell intention = 
				new IntentionBuySell(
				intentionDTO.getCryptoCurrency(),
				intentionDTO.getCryptoAmount(),
				intentionDTO.getPrice(),
				asd,
				userService.findById(intentionDTO.getUserEmail()),
				intentionDTO.getOperation()); 
		this.intentionRepository.save(intention);
	}
}
