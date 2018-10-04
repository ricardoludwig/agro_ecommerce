package br.com.ricardoludwig.user.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import br.com.ricardoludwig.user.model.UserModel;

public interface UserModelRepository extends CrudRepository<UserModel, BigInteger> {

	UserModel findByUsername(String username);

}
