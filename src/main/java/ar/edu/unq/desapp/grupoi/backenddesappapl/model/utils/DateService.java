package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;

@Service
public class DateService {
	private ZoneOffset zoneOffset = ZoneOffset.ofHours(3);
	
	public LocalDateTime getDate() {
		return LocalDateTime.now().atOffset(zoneOffset).toLocalDateTime();
	}
}
