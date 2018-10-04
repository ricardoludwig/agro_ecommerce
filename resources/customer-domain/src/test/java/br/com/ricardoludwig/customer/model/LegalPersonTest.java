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

		try {
			withValidAttribs = new LegalPerson.Builder()
					.name("Old Mac Donald's Farm")
					.login("omd@g.co")
					.email("omd@g.co")
					.document(new CNPJ("47508411000156"))
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
		new LegalPerson.Builder()
				.name("J")
				.login("jax9@gmail.com")
				.builder();
	}
	
	@Test(expected = InvalidLoginException.class)
	public void giveAInvalidLoginThrowExceptionTest() {
		new LegalPerson.Builder()
				.name("Old Mac Donald's Farm")
				.email("jax9@gmail.com")
				.login("x@x.x")
				.builder();
	}
	
	@Test(expected = InvalidEmailException.class)
	public void giveAInvalidEmailThrowExceptionTest() {
		new LegalPerson.Builder()
				.name("Old Mac Donald's Farm")
				.login("omd@g.co")
				.email("x@x.x")
				.builder();
	}
	
	@Test
	public void giveAInvalidDocThrowExceptionTest() {
		
		LegalPerson person = new LegalPerson.Builder()
				.name("Old Mac Donald's Farm")
				.login("omd@g.co")
				.email("omd@g.co")
				.document(new CNPJ("123456"))
				.builder();
		
		assertFalse(person.hasDocument());
	}

}
