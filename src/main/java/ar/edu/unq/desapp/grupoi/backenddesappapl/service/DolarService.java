package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.DolarCasasDTO;
import ar.edu.unq.desapp.grupoi.backenddesappapl.dto.DolarValueDTO;

@Service
public class DolarService {
	
	private RestTemplate template = new RestTemplate();
	
	private String urlDolar = "https://www.dolarsi.com/api/api.php?type=dolar";
	
	
	public DolarValueDTO getDolarOficialValue() {
		ResponseEntity<DolarCasasDTO[]> dolarEntity = template.getForEntity(urlDolar, DolarCasasDTO[].class);
		
		DolarValueDTO dolarOficial = null;
		for(DolarCasasDTO dolarCasa : dolarEntity.getBody()) {
			if (StringUtils.equals(dolarCasa.getCasa().getNombre(), "Oficial"))
				dolarOficial = dolarCasa.getCasa();			
		}
		
		return dolarOficial;
		
	}

}
