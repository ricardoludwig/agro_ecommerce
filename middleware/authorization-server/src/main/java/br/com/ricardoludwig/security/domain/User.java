package br.com.ricardoludwig.security.domain;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String email;

	private boolean activated;

	private String activationKey;

	private String resetPasswordKey;

	private Set<Authority> authorities;

	public User() {
	}

	public User(String username, String password, String email, boolean activated, String firstName, String lastName,
			String activationKey, String resetPasswordKey, Set<Authority> authorities) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.activated = activated;
		this.activationKey = activationKey;
		this.resetPasswordKey = resetPasswordKey;
		this.authorities = authorities;
	}

	public User(String username, String password, String email, boolean activated, Set<Authority> authorities) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.activated = activated;
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getResetPasswordKey() {
		return resetPasswordKey;
	}

	public void setResetPasswordKey(String resetPasswordKey) {
		this.resetPasswordKey = resetPasswordKey;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
}