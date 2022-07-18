package com.smartLab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -5459564727580273797L;

	public BadRequestException() {
		this("EntityRepresentationModel not found!");
	}

	public BadRequestException(String message) {
		this(message, null);
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
