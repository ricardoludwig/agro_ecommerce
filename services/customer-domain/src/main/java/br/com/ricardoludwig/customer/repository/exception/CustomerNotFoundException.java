package br.com.ricardoludwig.customer.repository.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String msg) {
		super(msg);
	}
	
	public CustomerNotFoundException() {
		super("customer.not.found");
	}

	public CustomerNotFoundException(Exception e) {
		super("customer.not.found", e);
	}
}
