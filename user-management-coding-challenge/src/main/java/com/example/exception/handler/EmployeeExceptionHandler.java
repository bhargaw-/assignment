package com.example.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.UserCreationException;
import com.example.exception.UserNotFoundException;
import com.example.model.ErrorMessage;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<ErrorMessage> userNotFoundException(Throwable throwable) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorMessage(HttpStatus.NOT_FOUND.value(), throwable.getMessage()));
	}

	@ExceptionHandler(UserCreationException.class)
	ResponseEntity<ErrorMessage> userCreatedException(Throwable throwable) {
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE.value())
				.body(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), throwable.getMessage()));
	}	
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorMessage> anyOtherException(Throwable throwable) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.body(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), throwable.getMessage()));
	}

}
