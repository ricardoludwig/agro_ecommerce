package br.com.ricardoludwig.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.ricardoludwig.security.model.UserAuthority;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, String> {

	UserAuthority findByUsername(@Param("username") String username);

}