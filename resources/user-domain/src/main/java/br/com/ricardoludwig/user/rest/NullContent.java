package br.com.ricardoludwig.user.rest;

public class NullContent extends UserRequestBody {

	public String getUsername() {
		return "";
	}

	public String getPassword() {
		return "";
	}

}
