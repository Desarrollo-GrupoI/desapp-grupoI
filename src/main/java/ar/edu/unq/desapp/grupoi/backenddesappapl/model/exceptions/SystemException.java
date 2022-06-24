package ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions;

public class SystemException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public SystemException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
