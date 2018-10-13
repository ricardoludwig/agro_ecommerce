package br.com.ricardoludwig.customer.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class SecurityConfiguration extends ResourceServerConfigurerAdapter {

	private final static String resourceId = "resources";

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	
    	http.authorizeRequests()
				.antMatchers("/", "/instances/*", "/ui/*").permitAll()
		    	.anyRequest().authenticated();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(resourceId);
	}
	
}