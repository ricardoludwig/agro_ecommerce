package br.com.ricardoludwig.user.domain;

import br.com.ricardoludwig.user.model.UserModel;
import br.com.ricardoludwig.user.model.exception.InvalidUserException;

public final class User {

	private final Email _username;
	private final String _password;
	private final boolean _activated;

	public User(Email username, String password, boolean activated) {
		super();
		_username = checkUSername(username);
		_password = password;
		_activated = activated;
	}

	public Email getUsername() {
		return _username;
	}

	public String getPassword() {
		return _password;
	}

	public boolean isActivated() {
		return _activated;
	}

	private Email checkUSername(Email username) {
		if (username != null && username.isValid())
			return username;
		throw new InvalidUserException();
	}

	public static User valueOf(UserModel user) {

		if (user == null)
			throw new IllegalArgumentException("UserModel object is null");

		return new User(
				new Email(user.getUsername()), 
				user.getPassword(), 
				user.isActivated());

	}

}
