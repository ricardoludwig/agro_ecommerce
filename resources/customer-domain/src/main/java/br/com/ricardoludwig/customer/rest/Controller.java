

package br.com.ricardoludwig.customer.rest;


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

import br.com.ricardoludwig.customer.model.Customer;
import br.com.ricardoludwig.customer.service.CustomerService;
import br.com.ricardoludwig.customer.util.StringUtils;

@RestController
public class Controller {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

	@PostMapping("/customer")
	public ResponseEntity<Response> createOne(@Valid @RequestBody Content req) {
		
		
		Customer customer = req.toCustomer();
		
		service.hasPersistedLogin(customer);
		
		customer = service.createOne(customer);
		
		Response response = new Response(customer, "customer.created");
		response.add(linkTo(methodOn(Controller.class).createOne(req)).withSelfRel());
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<Response> readOne(@RequestParam("login") String login) {

		if (StringUtils.isEmpty(login)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Customer customer = service.findBy(login);
		
		Response response = new Response(customer, "customer.found");
		response.add(linkTo(methodOn(Controller.class).readOne(login)).withSelfRel());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<Response> updateOne(@Valid @RequestBody Content req) {

		Customer customer = service.updateOne(req.toCustomer());
		
		Response response = new Response(customer, "customer.updated");
		response.add(linkTo(methodOn(Controller.class).updateOne(req)).withSelfRel());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/customer/{login}")
	public ResponseEntity<Response> deleteOneByLogin(@PathVariable("login") String login) {

		if (StringUtils.isEmpty(login)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		Customer customer = service.disableBy(login);
		
		Response response = new Response(customer, "customer.deleted");
		response.add(linkTo(methodOn(Controller.class).deleteOneByLogin(login)).withSelfRel());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
