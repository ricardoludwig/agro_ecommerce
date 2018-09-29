package br.com.ricardoludwig.customer.rest;

import java.util.Collection;
import java.util.List;

import br.com.ricardoludwig.customer.model.CNPJ;
import br.com.ricardoludwig.customer.model.CNPJ.EnumCNPJ;
import br.com.ricardoludwig.customer.model.CPF;
import br.com.ricardoludwig.customer.model.CPF.EnumCPF;
import br.com.ricardoludwig.customer.model.Customer;
import br.com.ricardoludwig.customer.model.LegalPerson;
import br.com.ricardoludwig.customer.model.NaturalPerson;
import br.com.ricardoludwig.customer.model.exception.InvalidCustomerException;
import br.com.ricardoludwig.customer.rest.validation.EmailConstraint;
import br.com.ricardoludwig.customer.rest.validation.LoginConstraint;

public class Content {

	private String $name;
	
	@EmailConstraint
	private String $email;
	
	@LoginConstraint
	private String $login;
	
	private String $birthDate;
	
	private String $document;
	
	private String $typeOfDocument;
	
	private String $creditCard;
	
	private String $phones;

	public String getName() {
		return $name;
	}

	public void setName(String name) {
		$name = name;
	}

	public String getEmail() {
		return $email;
	}

	public void setEmail(String email) {
		$email = email;
	}
	
	public String getLogin() {
		return $login;
	}

	public void setLogin(String login) {
		$login = login;
	}

	public String getBirthDate() {
		return $birthDate;
	}

	public void setBirthDate(String birthDate) {
		$birthDate = birthDate;
	}

	public String getDocument() {
		return $document;
	}

	public void setDocument(String document) {
		$document = document;
	}

	public String getTypeOfDocument() {
		return $typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		$typeOfDocument = typeOfDocument;
	}

	public String getCreditCard() {
		return $creditCard;
	}

	public void setCreditCard(String creditCard) {
		$creditCard = creditCard;
	}

	public String getPhones() {
		return $phones;
	}

	public void setPhones(String phones) {
		$phones = phones;
	}
	
	public Customer toCustomer() {
		
		if (EnumCNPJ.value().equalsIgnoreCase($typeOfDocument)) {
			return new LegalPerson.Builder().login($login)
					.email($email)
					.document(new CNPJ($document))
					.name($name)
					.phone($phones)
					.creditCard($creditCard)
					.builder();
		} else if (EnumCPF.value().equalsIgnoreCase($typeOfDocument)) {
			return new NaturalPerson.Builder().login($login)
					.email($email)
					.document(new CPF($document))
					.name($name)
					.phone($phones)
					.creditCard($creditCard)
					.builder();
		}
		
		throw new InvalidCustomerException();		
	}
	
	public static Content valueOf(Customer $customer) {
	
		if ($customer == null) {
			return new NullContent();
		}
		
		Content content = new Content();
		content.setName($customer.getName());
		content.setEmail($customer.getEmail().toString());
		content.setLogin($customer.getLogin().toString());
		content.setDocument($customer.getDocument().getNumber());

		Collection<String> phones = $customer.getPhones();
		if (!phones.isEmpty()) {
			content.setPhones(((List<String>) phones).get(0));
		}

		Collection<String> creditCards = $customer.getCreditCards();
		if (!creditCards.isEmpty()) {
			content.setCreditCard(((List<String>) creditCards).get(0));
		}

		return content;

	}

}
