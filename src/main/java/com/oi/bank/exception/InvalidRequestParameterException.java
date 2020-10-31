package com.oi.bank.exception;

import lombok.Data;

@Data
public class InvalidRequestParameterException extends RuntimeException{

	private static final long serialVersionUID = 4899276294692126152L;
	
	private String parameterName;
	
	private String message;

	public InvalidRequestParameterException() {
		super();
	}


	public InvalidRequestParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRequestParameterException(String message) {
		super(message);
	}
	
	public InvalidRequestParameterException(String parameterName ,String message) {
		this.parameterName=parameterName;
		this.message=message;
	}

	public InvalidRequestParameterException(Throwable cause) {
		super(cause);
	}
	
	

}
