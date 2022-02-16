package com.eric.elis.exception;

import java.lang.RuntimeException;
import java.lang.String;

public class ServersNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServersNotFoundException() {
		super();
	}

	public ServersNotFoundException(String message) {
		super(message);
	}
}
