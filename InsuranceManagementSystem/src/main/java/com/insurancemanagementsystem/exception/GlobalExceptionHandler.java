package com.insurancemanagementsystem.exception;

import java.util.Collections; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,List<String>>> handleValidationError(MethodArgumentNotValidException ex)
	{
		List<String> errors=ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());
		return new ResponseEntity<>(getErrorMap(errors),new HttpHeaders(),HttpStatus.BAD_REQUEST);
	}
	private Map<String,List<String>> getErrorMap(List<String>errors){
		Map<String,List<String>> errorResponse= new HashMap<>();
		errorResponse.put("errors", errors);
		return errorResponse;
	}
	
	@ExceptionHandler(ClientDetailsNotFoundException.class)
	public ResponseEntity<Map<String,List<String>>> ClientDetailsNotFoundException(ClientDetailsNotFoundException ex)
	{
		List<String> errors=Collections.singletonList(ex.getMessage());
		return new ResponseEntity<>(getErrorMap(errors),new HttpHeaders(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ClaimDetailsNotFoundException.class)
	public ResponseEntity<Map<String,List<String>>> ClaimDetailsNotFoundException(ClaimDetailsNotFoundException ex)
	{
		List<String> errors=Collections.singletonList(ex.getMessage());
		return new ResponseEntity<>(getErrorMap(errors),new HttpHeaders(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InsuranceDetailsNotFoundException.class)
	public ResponseEntity<Map<String,List<String>>> InsuranceDetailsNotFoundException(InsuranceDetailsNotFoundException ex)
	{
		List<String> errors=Collections.singletonList(ex.getMessage());
		return new ResponseEntity<>(getErrorMap(errors),new HttpHeaders(),HttpStatus.BAD_REQUEST);
	}
}
