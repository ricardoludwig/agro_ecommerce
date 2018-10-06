package br.com.ricardoludwig.user.rest;

import br.com.ricardoludwig.user.domain.Email;
import br.com.ricardoludwig.user.domain.User;
import br.com.ricardoludwig.user.repository.exception.UserNotFoundException;

public class UserResponseBody {

	private final String _username;
	private final String _password;
	private final boolean _activated;

	public UserResponseBody(String username, String password, boolean activated) {
		super();
		_username = username;
		_password = password;
		_activated = activated;
		
	}

	public UserResponseBody(User user) {
		super();
		if (user == null) {
			throw new UserNotFoundException();
		}
		Email usrName = user.getUsername();
		_username = usrName.toString();
		_password = user.getPassword();
		_activated = user.isActivated();
	}

	public String getUsername() {
		return _username;
	}
	
	public String getPassword() {
		return _password;
	}

	public boolean isActivated() {
		return _activated;
	}

}
