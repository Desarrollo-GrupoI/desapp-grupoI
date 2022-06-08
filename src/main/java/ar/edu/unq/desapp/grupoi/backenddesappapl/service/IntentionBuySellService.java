package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.DolarCasasDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.DolarValueDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.RegisterIntentionDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.IntentionBuySell;
import ar.edu.unq.desapp.grupoi.backenddesappapl.repositories.IntentionBuySellRepository;

@Service
public class IntentionBuySellService {
	
	@Autowired
	private IntentionBuySellRepository intentionRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DolarService dolarService;
	
	
	@Transactional
	public void save(RegisterIntentionDTO intentionDTO) {
		
		DolarValueDTO dolarOficial = dolarService.getDolarOficialValue();
		IntentionBuySell intention = 
				new IntentionBuySell(
					intentionDTO.getCryptoCurrency(),
					intentionDTO.getCryptoAmount(),
					intentionDTO.getPrice(),
					intentionDTO.getPrice() * dolarOficial.getVenta(),
					userService.findById(intentionDTO.getUserEmail()),
					intentionDTO.getOperation()); 
		this.intentionRepository.save(intention);
	}
	
	
	
		
		
		
					
	
}
