package it.itsrizzoli.ifts2021.springsportshub.exceptions;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundException(Object id) {
		super("Could not find record by this id: " + id);
	}
}
