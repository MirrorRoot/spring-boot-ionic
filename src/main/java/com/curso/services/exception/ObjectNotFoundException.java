package com.curso.services.exception;

import org.springframework.stereotype.Component;


public class ObjectNotFoundException extends RuntimeException {

	

private static final long serialVersionUID = 2331270849889353108L;

public ObjectNotFoundException(String msg) {
	super(msg);
}

public ObjectNotFoundException(String msg, Throwable cause) {
	
	super(msg,cause);
}
	
	
}
