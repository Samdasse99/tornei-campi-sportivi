package it.itsrizzoli.ifts2021.springsportshub.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "record not found")
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
