package com.devsuperior.dsclient.services.exceptions;

public class ServiceExceptionNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ServiceExceptionNotFound(String msg) {
		super(msg);
	}

}
