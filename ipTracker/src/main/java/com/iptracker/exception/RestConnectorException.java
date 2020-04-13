package com.iptracker.exception;

public class RestConnectorException extends RuntimeException {

	public RestConnectorException() {
	}

	public RestConnectorException(String message) {
		super(message);
	}

	public RestConnectorException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestConnectorException(Throwable cause) {
		super(cause);
	}
}
