package br.com.ricardoludwig.user.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.ricardoludwig.user.domain.Email;
import br.com.ricardoludwig.user.model.exception.InvalidEmailException;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (value == null) 
			return true; //No email, validation is unneeded
		
		if (Email.isValid(value))
			return true;
		throw new InvalidEmailException("Invalid Email");
	}

}
