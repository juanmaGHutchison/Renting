package com.carRentig.rentig.exception;

public class ValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2360091946629238975L;

	public ValidationException() {
		super();
	}
	
	public ValidationException(String message) {
		super(message);
	}
}
