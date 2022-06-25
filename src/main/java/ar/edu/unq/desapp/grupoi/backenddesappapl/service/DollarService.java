package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.DolarCasasDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.DolarValueDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFoundException;

@Service
public class DollarService {
	private RestTemplate template = new RestTemplate();
	private String urlDolar = "https://www.dolarsi.com/api/api.php?type=dolar";
	
	public Float getDolarOficialSellValue() {
		ResponseEntity<DolarCasasDTO[]> dolarEntity = template.getForEntity(urlDolar, DolarCasasDTO[].class);
		
		DolarValueDTO dolarOficial = null;
		for(DolarCasasDTO dolarCasa : dolarEntity.getBody()) {
			if(StringUtils.equals(dolarCasa.getCasa().getName(), "Oficial"))
				dolarOficial = dolarCasa.getCasa();
		}
		
		if(dolarOficial == null)
			throw new EntityNotFoundException("The dollar's sell value is not found");
		
		return dolarOficial.getSellValue();
	}
}
