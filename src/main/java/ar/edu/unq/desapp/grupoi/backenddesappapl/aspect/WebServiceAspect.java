package ar.edu.unq.desapp.grupoi.backenddesappapl.aspect;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class WebServiceAspect {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Around("execution(* ar.edu.unq.desapp.grupoi.backenddesappapl.webservice.*.*(..))")
	private ResponseEntity<?> auditExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		LocalDateTime startTime = LocalDateTime.now();
		
		ResponseEntity<?> result;
		Object[] args = joinPoint.getArgs();
		
        try {
            result = (ResponseEntity<?>) joinPoint.proceed(args);
        } finally {}
        
		LocalDateTime endTime = LocalDateTime.now();
    	logger.log(Level.INFO, "Execution time: " + Duration.between(startTime, endTime).toMillis() + " milliseconds");
    	
    	return result;
    }
}
