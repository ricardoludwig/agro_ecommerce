package br.com.ricardoludwig.security.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;

@Entity
@Table(name = "USER_AUTHORITY", schema = "PUBLIC")
public class UserAuthority {

	@Id
	@NotNull
	private String username;

	private String authority;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public List<String> getRoles() {
		if (StringUtils.isEmpty(authority))
			return Collections.emptyList();
		String[] aRoles = authority.split(",");
		List<String> roles = Arrays.asList(aRoles);
		return roles;
	}

}
