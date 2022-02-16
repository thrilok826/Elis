package com.eric.elis.exception;

import java.lang.RuntimeException;
import java.lang.String;

public class EnvironmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EnvironmentNotFoundException() {
		super();
	}

	public EnvironmentNotFoundException(String message) {
		super(message);
	}
}
