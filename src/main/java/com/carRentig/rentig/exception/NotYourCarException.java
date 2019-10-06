package com.carRentig.rentig.exception;

public class NotYourCarException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7813444660458197173L;

	public NotYourCarException() {
		super();
	}
	
	public NotYourCarException(String message) {
		super(message);
	}
}
