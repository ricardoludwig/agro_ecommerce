package br.com.ricardoludwig.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.com.ricardoludwig.user.domain.User;

@Entity
@Table(name = "TB_USER", schema = "PUBLIC")
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public UserModel(String username, @Size(min = 0, max = 500) String password, boolean activated) {
		super();
		this.username = username;
		this.password = password;
		this.activated = activated;
	}
	
	public UserModel() {
		super();
	}

	@Id
	@Column(updatable = false, nullable = false)
	private String username;

	@Size(min = 0, max = 500)
	private String password;

	@Column
	private boolean activated;

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

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public static UserModel valueOf(User user) {
		if (user == null)
			throw new IllegalArgumentException("User object is null");
		return new UserModel(user.getUsername().toString(), user.getPassword(), user.isActivated());
	}

}