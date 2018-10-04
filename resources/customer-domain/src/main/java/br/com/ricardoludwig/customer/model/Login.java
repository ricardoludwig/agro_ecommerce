package br.com.ricardoludwig.customer.model;

public final class Login {

	private final String _login;
	private final boolean _valid;

	public Login(String login) {
		if (isValid(login)) {
			_login = login;
			_valid = true;
		} else {
			_login = "invalid.login";
			_valid = false;
		}
	}

	@Override
	public String toString() {
		return _login;
	}

	public boolean isValid() {
		return _valid;
	}

	public static boolean isValid(String login) {
		return Email.isValid(login);
	}

}
