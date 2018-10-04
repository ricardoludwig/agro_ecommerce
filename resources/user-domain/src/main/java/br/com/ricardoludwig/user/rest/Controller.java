
package br.com.ricardoludwig.user.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardoludwig.user.domain.User;
import br.com.ricardoludwig.user.service.UserService;
import br.com.ricardoludwig.user.util.StringUtils;

@RestController
public class Controller {

	@Autowired
	private UserService service;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

	@PostMapping("/user")
	public ResponseEntity<Response> createOne(@Valid @RequestBody UserRequestBody req) {

		User usr = req.toUser();

		service.hasPersistedLogin(usr);

		usr = service.createOne(usr);

		Response response = new Response(new UserResponseBody(usr), "user.created");
		response.add(linkTo(methodOn(Controller.class).createOne(req)).withSelfRel());

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/user")
	public ResponseEntity<Response> readOne(@RequestParam("username") String username) {

		if (StringUtils.isEmpty(username)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		User usr = service.findBy(username);

		Response response = new Response(new UserResponseBody(usr), "user.found");
		response.add(linkTo(methodOn(Controller.class).readOne(username)).withSelfRel());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity<Response> updateOne(@Valid @RequestBody UserRequestBody req) {

		User usr = service.updateOne(req.toUser());

		Response response = new Response(new UserResponseBody(usr), "user.updated");
		response.add(linkTo(methodOn(Controller.class).updateOne(req)).withSelfRel());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/user/{username}")
	public ResponseEntity<Response> deleteOneByLogin(@PathVariable("user") String user) {

		if (StringUtils.isEmpty(user)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		User usr = service.disableBy(user);

		Response response = new Response(new UserResponseBody(usr), "user.deleted");
		response.add(linkTo(methodOn(Controller.class).deleteOneByLogin(user)).withSelfRel());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
