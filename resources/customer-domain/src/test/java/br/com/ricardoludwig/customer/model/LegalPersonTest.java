package br.com.ricardoludwig.customer.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.ricardoludwig.customer.model.exception.InvalidEmailException;
import br.com.ricardoludwig.customer.model.exception.InvalidLoginException;
import br.com.ricardoludwig.customer.model.exception.InvalidNameException;

public class LegalPersonTest {

	private Customer withValidAttribs;

	@Before
	public void setUp() {

			withValidAttribs = new LegalPerson.Builder()
					.name("Old Mac Donald's Farm")
					.login("omd@g.co")
					.email("omd@g.co")
					.document(new CNPJ("47508411000156"))
					.builder();
	}

	@Test
	public void given_valid_name() {
		boolean name = withValidAttribs.hasName();
		assertTrue(name);
	}
	
	@Test
	public void given_valid_login() {
		boolean login = withValidAttribs.hasLogin();
		assertTrue(login);
	}
	
	@Test
	public void given_valid_email() {
		boolean login = withValidAttribs.hasEmail();
		assertTrue(login);
	}
	
	@Test
	public void given_valid_document() {
		boolean doc = withValidAttribs.hasDocument();
		assertTrue(doc);
	}

	@Test(expected = InvalidNameException.class)
	public void given_a_invalid_name() {
		new LegalPerson.Builder()
				.name("J")
				.login("jax9@gmail.com")
				.builder();
	}
	
	@Test(expected = InvalidLoginException.class)
	public void given_invalid_login() {
		new LegalPerson.Builder()
				.name("Old Mac Donald's Farm")
				.email("jax9@gmail.com")
				.login("x@x.x")
				.builder();
	}
	
	@Test(expected = InvalidEmailException.class)
	public void given_invalid_email() {
		new LegalPerson.Builder()
				.name("Old Mac Donald's Farm")
				.login("omd@g.co")
				.email("x@x.x")
				.builder();
	}
	
	@Test
	public void given_invalid_document() {
		
		LegalPerson person = new LegalPerson.Builder()
				.name("Old Mac Donald's Farm")
				.login("omd@g.co")
				.email("omd@g.co")
				.document(new CNPJ("123456"))
				.builder();
		
		assertFalse(person.hasDocument());
	}

}
