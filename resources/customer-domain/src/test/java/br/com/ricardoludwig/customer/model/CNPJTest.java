package br.com.ricardoludwig.customer.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CNPJTest {

	private CNPJ valid;
	private CNPJ inValid;

	@Before
	public void setUp() {
		valid = new CNPJ("47508411000156");
		inValid = new CNPJ("47508411000152");
	}

	@Test
	public void given_CNPJ_verify_If_valid() {
		assertTrue(valid.isValid());
	}

	@Test
	public void given_CNPJ_verify_If_invalid() {
		assertFalse(inValid.isValid());
	}

}
