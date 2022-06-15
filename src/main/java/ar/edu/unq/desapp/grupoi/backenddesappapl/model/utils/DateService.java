package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;
import java.time.*;

@Service
public class DateService {
	
	public LocalDateTime getDate() {
		return LocalDateTime.now();
	}
}
