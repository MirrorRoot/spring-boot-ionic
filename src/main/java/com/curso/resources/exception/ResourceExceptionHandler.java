package com.curso.resources.exception;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.request.WebRequest;

import com.curso.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
	ResponseEntity<StandartError> objectNoFound(ObjectNotFoundException ex,WebRequest request){
	StandartError error=new StandartError(HttpStatus.NOT_FOUND.value(),ex.getMessage(), System.currentTimeMillis())	;
	return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
	
		
	}
}
