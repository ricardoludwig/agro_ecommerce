package br.com.ricardoludwig.customer.model.exception;

public class InvalidEmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String msg) {
		super(msg);
	}
	
	public InvalidEmailException() {
		super("invalid.email");
	}

}
