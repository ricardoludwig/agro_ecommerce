package br.com.ricardoludwig.customer.model.exception;

public class InvalidNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidNameException(String msg) {
		super(msg);
	}
	
	public InvalidNameException() {
		super("invalid.name");
	}
}
