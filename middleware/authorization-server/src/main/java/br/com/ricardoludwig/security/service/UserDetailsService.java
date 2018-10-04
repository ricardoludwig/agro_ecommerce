package br.com.ricardoludwig.security.service;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ctc.wstx.dtd.OptionalModel;

import br.com.ricardoludwig.security.model.Authority;
import br.com.ricardoludwig.security.model.User;
import br.com.ricardoludwig.security.repository.UserRepository;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return findByUsername(username)
				.map(user -> new org.springframework.security.core.userdetails.User(user.getUsername(),
						user.getPassword(), getGrantedAuthorities(user)))
				.orElseThrow(() -> new UsernameNotFoundException("User " + username + " Not found"));
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private Collection<GrantedAuthority> getGrantedAuthorities(User user) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Authority authority : user.getAuthorities()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
			grantedAuthorities.add(grantedAuthority);
		}

		return grantedAuthorities;
	}
	
	private Optional<User> findByUsername(String username) {
		
		String password = "$2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy";
		String email = "admin@admin.com";
		boolean activated = true;
		String firstName = "";
		String lastName = "";
		String activationKey = "";
		String resetPasswordKey = "";
		
		Set<Authority> authorities = new HashSet<>();
		Authority authority = new Authority();
		authority.setName("TESTE");
		authorities.add(authority);
		
		User user = new User(username, password, email, activated, firstName, lastName, activationKey, resetPasswordKey, authorities);
		
		return Optional.ofNullable(user);
	}
}
