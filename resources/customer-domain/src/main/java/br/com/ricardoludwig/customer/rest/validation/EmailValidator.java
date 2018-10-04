package br.com.ricardoludwig.customer.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.ricardoludwig.customer.model.Email;
import br.com.ricardoludwig.customer.model.exception.InvalidEmailException;

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
