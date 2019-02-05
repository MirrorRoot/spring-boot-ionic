package com.curso.services.exception;


public class DataIntegrityException extends RuntimeException {

	

private static final long serialVersionUID = 2331270849889353108L;

public DataIntegrityException(String msg) {
	super(msg);
}

public DataIntegrityException(String msg, Throwable cause) {
	
	super(msg,cause);
}
	
	
}
