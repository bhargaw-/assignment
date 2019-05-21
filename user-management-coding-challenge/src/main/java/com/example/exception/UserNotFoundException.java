package com.example.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4339234214005666272L;
	
	public UserNotFoundException(String errorString) {
		super(errorString);
	}

}
