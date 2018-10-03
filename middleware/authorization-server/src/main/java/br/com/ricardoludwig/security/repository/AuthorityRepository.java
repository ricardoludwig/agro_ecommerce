package br.com.ricardoludwig.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoludwig.security.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
	Authority findByName(String name);
	
}