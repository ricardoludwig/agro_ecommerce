package br.com.ricardoludwig.customer.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LegalPerson extends Customer {

	private final String _name;
	private final Login _login;
	private final Email _email;
	private final Document _document;
	private final Collection<String> _creditCards;
	private final Collection<String> _phones;

	public static class Builder {

		private String name;
		private String login;
		private String email;
		private Document document;
		private Collection<String> creditCards;
		private Collection<String> phones;

		public Builder name(String value) {
			name = value;
			return this;
		}

		public Builder login(String value) {
			login = value;
			return this;
		}

		public Builder email(String value) {
			email = value;
			return this;
		}

		public Builder document(Document value) {
			document = value;
			return this;
		}
		
		public Builder creditCard(String ... args) {
			List<String> creditCardList = Arrays.asList(args);
			if (creditCardList.isEmpty()) {
				creditCards = Collections.emptyList();
				return this;
			}
			
			creditCards = new HashSet<String>(creditCardList.size());
			creditCards.addAll(creditCardList);
			
			return this;
			
		}
		
		public Builder phone(String ... args) {
			List<String> phoneList = Arrays.asList(args);
			if (phoneList.isEmpty()) {
				creditCards = Collections.emptyList();
				return this;
			}
			
			phones = new HashSet<String>(phoneList.size());
			phones.addAll(phoneList);
			
			return this;
			
		}

		public LegalPerson builder() {
			return new LegalPerson(name, login, email, document, creditCards, phones);
		}

	}

	private LegalPerson(String name, String login, String email, Document document, Collection<String> creditCards, Collection<String> phones) {
		_name = name;
		_login = new Login(login);
		_email = new Email(email);
		_document = document;
		_creditCards = creditCards;
		_phones = phones;

		init();
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	boolean hasName() {
		return super.hasName();
	}

	@Override
	public Login getLogin() {
		return _login;
	}

	@Override
	boolean hasLogin() {
		return super.hasLogin();
	}

	@Override
	public Email getEmail() {
		return _email;
	}

	@Override
	boolean hasEmail() {
		return super.hasEmail();
	}

	@Override
	public Document getDocument() {
		return _document;
	}

	@Override
	boolean hasDocument() {
		return _document.isValid();
	}

	@Override
	public Collection<String> getPhones() {
		if (_phones == null) {
			return Collections.emptySet();
		}
		return Collections.unmodifiableCollection(_phones);
	}

	@Override
	public Collection<String> getCreditCards() {
		if (_creditCards == null) {
			return Collections.emptySet();
		}
		return Collections.unmodifiableCollection(_creditCards);
	}

	@Override
	public String toString() {
		return "LegalPerson [_name=" + _name + ", _login=" + _login + ", _email=" + _email + ", _document=" + _document
				+ ", _creditCards=" + _creditCards + ", _phones=" + _phones + "]";
	}

}
