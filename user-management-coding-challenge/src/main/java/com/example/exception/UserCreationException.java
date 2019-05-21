package com.example.exception;

public class UserCreationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9008172583548835192L;
	
	
	public UserCreationException(String errorString) {
		super(errorString);
	}

}
