package com.akash.spring.crm.test.webservices.rest.exception;

public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorInformation error;

	public ResourceNotFoundException(ErrorInformation error) {
		this.error = error;
	}

	public ErrorInformation getErrorObject() {
		return this.error;
	}
}
