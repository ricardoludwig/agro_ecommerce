package br.com.ricardoludwig.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ricardoludwig.security.model.UserAuthority;
import br.com.ricardoludwig.security.remote.UserResource;
import br.com.ricardoludwig.security.repository.UserAuthorityRepository;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	private UserResource userRemoteResource;
	private UserAuthorityRepository userAuthorityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetails ud = userRemoteResource.findUser(username)
				.map(user -> new org.springframework.security.core.userdetails.User(user.getUsername(),
						user.getPassword(), getGrantedAuthorities(username)))
				.orElseThrow(() -> new UsernameNotFoundException("User " + username + " Not found"));

		return ud;
	}

	@Autowired
	public void setUserRemoteResource(UserResource userRemote) {
		userRemoteResource = userRemote;
	}

	@Autowired
	public void setUserAuthorityRepository(UserAuthorityRepository userAuthRepository) {
		userAuthorityRepository = userAuthRepository;
	}

	private List<GrantedAuthority> getGrantedAuthorities(String username) {

		UserAuthority uas = userAuthorityRepository.findByUsername(username);
		List<String> roles = uas.getRoles();

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (String role : roles) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
			grantedAuthorities.add(grantedAuthority);
		}

		return grantedAuthorities;
	}

}
