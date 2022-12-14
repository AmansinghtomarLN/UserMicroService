package com.lcwd.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
		ApiResponse response = new ApiResponse();
		
		response.setMessage(ex.getMessage());
		response.setSuccess(false);
		response.setStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
}
