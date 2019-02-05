package com.curso.resources.exception;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.request.WebRequest;

import com.curso.services.exception.DataIntegrityException;
import com.curso.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
	ResponseEntity<StandartError> objectNoFound(ObjectNotFoundException ex,WebRequest request){
	StandartError error=new StandartError(HttpStatus.NOT_FOUND.value(),ex.getMessage(), System.currentTimeMillis())	;
	return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
	
		
	
    
    }
    
    @ExceptionHandler(DataIntegrityException.class)
	ResponseEntity<StandartError> dataIntegraty(DataIntegrityException ex,WebRequest request){
	StandartError error=new StandartError(HttpStatus.BAD_REQUEST.value(),ex.getMessage(), System.currentTimeMillis())	;
	return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	
		
	
    
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ValidationError> validation(MethodArgumentNotValidException ex,WebRequest request){
	ValidationError errors=new ValidationError(HttpStatus.BAD_REQUEST.value(),ex.getMessage(), System.currentTimeMillis())	;
	
	for(FieldError e: ex.getBindingResult().getFieldErrors()) {
		
		errors.addError(e.getField(), e.getDefaultMessage());
		
	}
	
	
	return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(errors);
	
		
	
    
    }
}
