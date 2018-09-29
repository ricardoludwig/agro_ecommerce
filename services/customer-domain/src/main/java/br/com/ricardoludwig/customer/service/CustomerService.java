package br.com.ricardoludwig.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoludwig.customer.entity.CustomerEntity;
import br.com.ricardoludwig.customer.model.CNPJ;
import br.com.ricardoludwig.customer.model.CPF;
import br.com.ricardoludwig.customer.model.Customer;
import br.com.ricardoludwig.customer.model.LegalPerson;
import br.com.ricardoludwig.customer.model.Login;
import br.com.ricardoludwig.customer.model.NaturalPerson;
import br.com.ricardoludwig.customer.repository.CustomerRepository;
import br.com.ricardoludwig.customer.repository.exception.CustomerAlreadyExistException;
import br.com.ricardoludwig.customer.repository.exception.CustomerNotFoundException;
import br.com.ricardoludwig.customer.util.StringUtils;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository $repository) {
		if ($repository == null) 
			throw new IllegalArgumentException("Customer repository not found.");
		repository = $repository;
	}
	
	public Customer updateOne(Customer customer) {
		return createOne(customer);
	}

	public Customer createOne(final Customer customer) {
		
		CustomerEntity entity = CustomerEntity.valueOf(customer);
		entity = repository.save(entity);
		Customer saved = getCustomer(entity);
		
		return saved;
	}
	
	public void hasPersistedLogin(final Customer customer) {
		Login login = customer.getLogin();
		try {
			findEntityByLogin(login.toString());
		} catch (CustomerNotFoundException e) {
			return;
		} catch (Exception e) {
			throw new IllegalArgumentException("invalid.state.fail.insert.login");
		}
		
		throw new CustomerAlreadyExistException();
	}
	
	public Customer disableBy(String login) {
		CustomerEntity entity = findEntityByLogin(login);
		entity.setDisable(true);
		repository.save(entity);
		return getCustomer(entity);
	}

	public Customer findBy(String login) {
		CustomerEntity entity = findEntityByLogin(login);
		return getCustomer(entity);
		
	}

	private CustomerEntity findEntityByLogin(String login) {
		CustomerEntity entity = repository.findByLogin(login);
		if (entity == null || StringUtils.isEmpty(login)) {
			throw new CustomerNotFoundException();
		}
		return entity;
	}
	
	private Customer getCustomer(CustomerEntity entity) {
		CPF cpf = new CPF(entity.getDocument());
		if (cpf.isValid()) {
			return getNaturalPerson(entity, cpf);
		}
		
		CNPJ cnpj = new CNPJ(entity.getDocument());
		if (cnpj.isValid()) {
			return getLegalPerson(entity, cnpj);
		}
		
		throw new CustomerNotFoundException();
	}

	private Customer getLegalPerson(CustomerEntity entity, CNPJ cnpj) {

		try {
			return new LegalPerson.Builder().login(entity.getLogin())
					.email(entity.getEmail())
					.name(entity.getName())
					.document(cnpj)
					.phone(entity.getPhones())
					.creditCard(entity.getCreditCards()).builder();
			
		} catch (Exception e) {
			throw new CustomerNotFoundException(e);
		}
		
	}

	private Customer getNaturalPerson(CustomerEntity entity, CPF cpf) {
		
		try {
			return new NaturalPerson.Builder().login(entity.getLogin())
					.email(entity.getEmail())
					.name(entity.getName())
					.document(cpf)
					.phone(entity.getPhones())
					.creditCard(entity.getCreditCards()).builder();
			
		} catch (Exception e) {
			throw new CustomerNotFoundException(e);
		}
		
	}
	
}
