package ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions;

public class DolarOficialNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public DolarOficialNotFound(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
