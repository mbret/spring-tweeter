package com.springapp.domain.exception;

public class ActivationNotFoundException extends RuntimeException {

	public ActivationNotFoundException(String message) {
		super(message);
	}
}
