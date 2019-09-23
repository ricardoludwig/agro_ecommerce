package br.com.ricardoludwig.customer.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CPFTest {

	private CPF valid;
	private CPF inValid;

	@Before
	public void setUp() {
		valid = new CPF("02869476094");
		inValid = new CPF("02869476096");
	}

	@Test
	public void given_CPF_verify_If_valid() {
		assertTrue(valid.isValid());
	}

	@Test
	public void given_CPF_verify_If_invalid() {
		assertFalse(inValid.isValid());
	}
}
