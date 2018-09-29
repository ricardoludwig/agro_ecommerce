package br.com.ricardoludwig.customer.model.exception;

public class InvalidDocumentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidDocumentException(String msg) {
		super(msg);
	}

}
