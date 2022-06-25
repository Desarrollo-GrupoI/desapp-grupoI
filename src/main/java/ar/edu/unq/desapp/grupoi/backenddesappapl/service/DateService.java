package ar.edu.unq.desapp.grupoi.backenddesappapl.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class DateService {
	
	public LocalDateTime getDate() {
		return LocalDateTime.now();
	}
}
