package br.com.ricardoludwig.zuul.security.remote;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserResource {

	@Autowired
	private DiscoveryClient discoveryClient;

	public Content findUser(String username) {

		String request = getUri() + "/user?username=" + username;

		UserResponse userResponse = remoteCall(request);
		if (userResponse == null)
			throw new IllegalArgumentException("User not found");
		
		Content content = userResponse.getContent();
		return content;
	}

	private UserResponse remoteCall(String request) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			UserResponse urp = restTemplate.getForObject(request, UserResponse.class);
			return urp;
		} catch (ResourceAccessException e) {
			return herokuFallBack(request);
		} catch (Exception e) {
			e.printStackTrace(); // TODO Tratar exception
			return null;
		}
	}

	private UserResponse herokuFallBack(String request) { //TODO - Verificar solucao para o problema de connection refused do Heroku e remover esse fallback
		String username = request.split("=")[1];
		try {
			UserResponse usr = remoteCall("http://ricardoludwig-user-domain.herokuapp.com/user?username=" + username);
			return usr;
		} catch (Exception e) {
			throw new IllegalStateException("Heroku fallback fail", e);
		}
	}

	private String getUri() {
		List<ServiceInstance> instances = discoveryClient.getInstances("user-domain");

		for (ServiceInstance si : instances) {
			URI uri = si.getUri();
			if (uri != null) {
				return uri.toString();
			}
		}

		return "http://localhost:8083";
	}

}
