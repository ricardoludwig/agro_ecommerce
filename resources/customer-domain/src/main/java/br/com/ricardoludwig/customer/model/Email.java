package br.com.ricardoludwig.customer.model;

public class Email {

	private final String _email;
	private final boolean _valid;

	public Email(String email) {

		if (isValid(email)) {
			_email = email;
			_valid = true;
		} else {
			_email = "";
			_valid = false;
		}
	}

	public boolean isValid() {
		return _valid;
	}

	public static boolean isValid(String email) {
		if (email == null) {
			return false;
		}

		String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(pattern);
	}

	@Override
	public String toString() {
		return _email;
	}

}
