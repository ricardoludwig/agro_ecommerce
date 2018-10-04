package br.com.ricardoludwig.user.rest;

import br.com.ricardoludwig.user.domain.Email;
import br.com.ricardoludwig.user.domain.User;
import br.com.ricardoludwig.user.rest.validation.EmailConstraint;

public class UserRequestBody {

	@EmailConstraint
	private String $username;

	private String $password;

	public String getUsername() {
		return $username;
	}

	public void setUsername(String email) {
		$username = email;
	}

	public String getPassword() {
		return $password;
	}

	public void setPassword(String password) {
		$password = password;
	}

	public User toUser() {
		Email email = new Email($username);
		return new User(email, $password, true);
	}

}
