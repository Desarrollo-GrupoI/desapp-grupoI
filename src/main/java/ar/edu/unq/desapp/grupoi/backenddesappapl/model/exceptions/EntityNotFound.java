package ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions;

public class EntityNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public EntityNotFound(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
