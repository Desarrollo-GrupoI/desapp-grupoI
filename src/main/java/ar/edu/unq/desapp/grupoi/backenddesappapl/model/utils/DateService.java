package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;
import java.time.*;

@Service
public class DateService {
	private ZoneOffset zoneOffset = ZoneOffset.ofHours(3);
	private ZoneId zid = ZoneId.of("America/Buenos_Aires");
	
	public LocalDateTime getDate() {
		//return LocalDateTime.now().atOffset(zoneOffset).toLocalDateTime();
		return LocalDateTime.now(zid);
	}
}
