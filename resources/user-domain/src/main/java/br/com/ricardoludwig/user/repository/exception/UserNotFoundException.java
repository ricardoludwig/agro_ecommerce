package br.com.ricardoludwig.user.repository.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	public UserNotFoundException() {
		super("user.not.found");
	}

	public UserNotFoundException(Exception e) {
		super("user.not.found", e);
	}
}
