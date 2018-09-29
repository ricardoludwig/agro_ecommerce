package br.com.ricardoludwig.customer.model;

import java.util.Collection;

import br.com.ricardoludwig.customer.model.exception.InvalidEmailException;
import br.com.ricardoludwig.customer.model.exception.InvalidLoginException;
import br.com.ricardoludwig.customer.model.exception.InvalidNameException;

public abstract class Customer {

	public abstract String getName();

	public abstract Login getLogin();

	public abstract Email getEmail();

	public abstract Document getDocument();
	
	public abstract Collection<String> getPhones();
	
	public abstract Collection<String> getCreditCards();
	
	void init() {
		
		if (!hasName()) {
			throw new InvalidNameException();
		}
		
		if (!hasEmail()) {
			throw new InvalidEmailException();
		}
		
		if (!hasLogin()) {
			throw new InvalidLoginException();
		}
	}
	
	boolean hasName() {
		String name = getName();
		return (name == null ? false : name.length() > 2);
	}

	boolean hasLogin() {
		Login login = getLogin();
		return login.isValid();
	}

	boolean hasEmail() {
		Email email = getEmail();
		return email.isValid();
	}

	boolean hasDocument() {
		Document document = getDocument();
		return document.isValid();
	}

}
