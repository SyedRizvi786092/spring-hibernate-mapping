package com.example.HibernateMapping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({InvalidIdException.class, NotFoundException.class})
	public ResponseEntity<String> handleGetByIdExceptions(Exception exception) {
		String message = exception.getLocalizedMessage();
		if(exception instanceof InvalidIdException)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
}
