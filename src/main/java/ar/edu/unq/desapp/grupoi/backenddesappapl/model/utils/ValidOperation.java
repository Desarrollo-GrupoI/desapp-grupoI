package ar.edu.unq.desapp.grupoi.backenddesappapl.model.utils;

import ar.edu.unq.desapp.grupoi.backenddesappapl.model.Operation;
import ar.edu.unq.desapp.grupoi.backenddesappapl.model.exceptions.EntityNotFoundException;

public class ValidOperation {
	private Operation operation;
	
	public ValidOperation(String operation) {
		try {
			this.operation = Operation.valueOf(operation.toUpperCase());
		} catch(IllegalArgumentException exception) {
			throw new EntityNotFoundException("The operation '" + operation + "' was not found");
		}
	}

	public Operation getOperation() {
		return this.operation;
	}
}
