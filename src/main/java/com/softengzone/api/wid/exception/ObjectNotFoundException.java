package com.softengzone.api.wid.exception;

public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = -7461746577691741867L;
	
	public ObjectNotFoundException(String message) {
		super(message);
	}
	
	public ObjectNotFoundException(Exception e) {
		super(e);
	}
	
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
