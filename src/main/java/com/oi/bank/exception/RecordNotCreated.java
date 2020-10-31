package com.oi.bank.exception;

public class RecordNotCreated extends RuntimeException{

	private static final long serialVersionUID = -4135552912122336884L;

	public RecordNotCreated() {
		super();
	}

	public RecordNotCreated(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordNotCreated(String message) {
		super(message);
	}

	public RecordNotCreated(Throwable cause) {
		super(cause);
	}
	
	

}
