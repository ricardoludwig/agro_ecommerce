package br.com.ricardoludwig.customer.entity;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.ricardoludwig.customer.model.Customer;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	private String name;
	private String login;
	private String email;
	private String document;
	private String phones;
	private String creditCards;
	private boolean disable;
	
	public CustomerEntity() {
		super();
	}

	public CustomerEntity(String $name, String $login, String $email, String $document, String $documentType,
			String $phones, String $creditCards) {
		name = $name;
		login = $login;
		email = $email;
		document = $document;
		phones = $phones;
		creditCards = $creditCards;
	}

	private CustomerEntity(Customer $customer) {
		if ($customer == null)
			throw new IllegalArgumentException("Invalid customer object");
		
		name = $customer.getName();
		login = $customer.getLogin().toString();
		email = $customer.getEmail().toString();
		document = $customer.getDocument().getNumber();
		Collection<String> ph = $customer.getPhones();
		for (Iterator<String> iterator = ph.iterator(); iterator.hasNext();) {
			phones = (String) iterator.next();
		}
		
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger $id) {
		id = $id;
	}

	public String getName() {
		return name;
	}

	public void setName(String $name) {
		name = $name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String $login) {
		login = $login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String $email) {
		email = $email;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String $document) {
		document = $document;
	}
	
	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean $disable) {
		disable = $disable;
	}

	public String getCreditCards() {
		if (creditCards == null) {
			return "";
		}
		return creditCards;
	}

	public void setCreditCards(String $creditCards) {
		creditCards = $creditCards;
	}

	public String getPhones() {
		if (phones == null)
			return "";
		return phones;
	}

	public void setPhones(String $phones) {
		phones = $phones;
	}
	
	public static CustomerEntity valueOf(Customer $customer) {
		return new CustomerEntity($customer);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerEntity other = (CustomerEntity) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", login=" + login + ", email=" + email + ", document="
				+ document + ", phones=" + phones + ", creditCards=" + creditCards + "]";
	}

}
