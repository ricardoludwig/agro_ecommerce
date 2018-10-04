package br.com.ricardoludwig.customer.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import br.com.ricardoludwig.customer.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, BigInteger> {

	CustomerEntity findByLogin(String login);

}
