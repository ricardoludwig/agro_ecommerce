package br.com.ricardoludwig.user.repository.exception;

public class UserAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistException(String msg) {
		super(msg);
	}
	
	public UserAlreadyExistException() {
		super("user.already.exist.exception");
	}

}
