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

		try {
			withValidAttribs = new NaturalPerson.Builder()
					.name("Jhonny Be Good")
					.login("jhonnybg@gmail.com")
					.email("jhonnybg@gmail.com")
					.document(new CPF("02869476094"))
					.builder();
		} catch (Exception e) {
			//Do nothing, just to prevent broke all tests when create a by mistake a wrong new object's instance.
		}
	}

	@Test
	public void giveAValidNameResultIsTrueTest() {
		boolean name = withValidAttribs.hasName();
		assertTrue(name);
	}
	
	@Test
	public void giveAValidLoginResultIsTrueTest() {
		boolean login = withValidAttribs.hasLogin();
		assertTrue(login);
	}
	
	@Test
	public void giveAValidEmailResultIsTrueTest() {
		boolean login = withValidAttribs.hasEmail();
		assertTrue(login);
	}
	
	@Test
	public void giveAValidDocumentResultIsTrueTest() {
		boolean doc = withValidAttribs.hasDocument();
		assertTrue(doc);
	}

	@Test(expected = InvalidNameException.class)
	public void giveAInvalidNameThrowExceptionTest() {
		new NaturalPerson.Builder()
				.name("Fak5")
				.login("jax9@gmail.com")
				.email("jax9@gmail.com")
				.builder();
	}
	
	@Test(expected = InvalidLoginException.class)
	public void giveAInvalidLoginThrowExceptionTest() {
		new NaturalPerson.Builder()
				.name("Mr. Fake")
				.email("jax9@gmail.com")
				.login("x@x.x")
				.builder();
	}
	
	@Test(expected = InvalidEmailException.class)
	public void giveAInvalidEmailThrowExceptionTest() {
		new NaturalPerson.Builder()
				.name("Mr. Fake")
				.login("omd@g.co")
				.email("x@x.x")
				.builder();
	}
	
	@Test
	public void giveAInvalidDocThrowExceptionTest() {
		NaturalPerson person = new NaturalPerson.Builder()
				.name("Mr. Fake")
				.login("omd@g.co")
				.email("omd@g.co")
				.document(new CPF("123456"))
				.builder();
		
		assertFalse(person.hasDocument());
	}

}
