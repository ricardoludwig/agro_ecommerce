package br.com.ricardoludwig.customer.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.ricardoludwig.customer.model.Login;
import br.com.ricardoludwig.customer.model.exception.InvalidLoginException;

public class LoginValidator implements ConstraintValidator<LoginConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (Login.isValid(value))
			return true;
		throw new InvalidLoginException("Invalid Login");
	}

}
