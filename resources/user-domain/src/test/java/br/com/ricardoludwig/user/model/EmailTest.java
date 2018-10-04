package br.com.ricardoludwig.user.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.ricardoludwig.user.domain.Email;

public class EmailTest {

	private Email valid;
	private Email inValid;

	@Before
	public void setUp() {
		valid = new Email("ricardo.ludwig@gmail.com");
		inValid = new Email("ricardo.ludwig.gmail.com");
	}

	@Test
	public void giveATrueEmailVerifyIfIsValid() {
		assertTrue(valid.isValid());
	}

	@Test
	public void giveAFalseEmailVerifyIfIsValid() {
		assertFalse(inValid.isValid());
	}

}
