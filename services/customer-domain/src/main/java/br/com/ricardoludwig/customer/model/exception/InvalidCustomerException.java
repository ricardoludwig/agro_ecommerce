package br.com.ricardoludwig.customer.model.exception;

public class InvalidCustomerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidCustomerException(String msg) {
		super(msg);
	}
	
	public InvalidCustomerException() {
		super("invalid.customer.exception");
	}

}
