package br.com.ricardoludwig.customer.model.exception;

public class InvalidLoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidLoginException(String msg) {
		super(msg);
	}

	public InvalidLoginException() {
		super("invalid.login");
	}

}
