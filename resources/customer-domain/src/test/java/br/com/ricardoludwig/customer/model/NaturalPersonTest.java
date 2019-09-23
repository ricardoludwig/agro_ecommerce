package br.com.ricardoludwig.customer.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.ricardoludwig.customer.model.exception.InvalidEmailException;
import br.com.ricardoludwig.customer.model.exception.InvalidLoginException;
import br.com.ricardoludwig.customer.model.exception.InvalidNameException;

public class NaturalPersonTest {

	private Customer withValidAttribs;

	@Before
	public void setUp() {

		withValidAttribs = new NaturalPerson.Builder()
				.name("Jhonny Be Good")
				.login("jhonnybg@gmail.com")
				.email("jhonnybg@gmail.com")
				.document(new CPF("02869476094"))
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
		new NaturalPerson.Builder()
				.name("Fak5")
				.login("jax9@gmail.com")
				.email("jax9@gmail.com")
				.builder();
	}
	
	@Test(expected = InvalidLoginException.class)
	public void given_invalid_login() {
		new NaturalPerson.Builder()
				.name("Mr. Fake")
				.email("jax9@gmail.com")
				.login("x@x.x")
				.builder();
	}
	
	@Test(expected = InvalidEmailException.class)
	public void given_invalid_email() {
		new NaturalPerson.Builder()
				.name("Mr. Fake")
				.login("omd@g.co")
				.email("x@x.x")
				.builder();
	}
	
	@Test
	public void given_invalid_document() {
		NaturalPerson person = new NaturalPerson.Builder()
				.name("Mr. Fake")
				.login("omd@g.co")
				.email("omd@g.co")
				.document(new CPF("123456"))
				.builder();
		
		assertFalse(person.hasDocument());
	}

}
