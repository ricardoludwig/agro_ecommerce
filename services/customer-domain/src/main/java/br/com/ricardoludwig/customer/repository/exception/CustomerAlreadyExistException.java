package br.com.ricardoludwig.customer.repository.exception;

public class CustomerAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CustomerAlreadyExistException(String msg) {
		super(msg);
	}
	
	public CustomerAlreadyExistException() {
		super("customer.already.exist.exception");
	}

}
