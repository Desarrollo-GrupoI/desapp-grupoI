package ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
	
	@ExceptionHandler(value = InvalidPasswordException.class)
	public ResponseEntity<Object> exception(InvalidPasswordException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
