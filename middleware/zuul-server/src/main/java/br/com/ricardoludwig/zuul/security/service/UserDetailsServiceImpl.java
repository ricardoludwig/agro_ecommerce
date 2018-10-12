package br.com.ricardoludwig.zuul.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ricardoludwig.zuul.security.remote.Content;
import br.com.ricardoludwig.zuul.security.remote.UserResource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	private UserResource resource;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Content user = resource.findUser(username);

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		grantList.add(authority);
	        
		UserDetails userDetails = (UserDetails) new User(user.getUsername(),  user.getPassword(), grantList);
		return userDetails;
		 
	}
	
	@Autowired
	public void setResource(UserResource resource) {
		this.resource = resource;
	}

}
