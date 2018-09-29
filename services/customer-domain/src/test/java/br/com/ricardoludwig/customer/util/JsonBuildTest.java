package br.com.ricardoludwig.customer.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JsonBuildTest {

	@Test
	public void jsonFormatTest() {

		String expected = "{\"name\":\"Jurgen Klinsmann\",\"email\":" + "\"jurgen.klinsmann@gmail.com\"}";
		
		String formatted = JsonBuild.jsonFormat("name", "Jurgen Klinsmann", "email", "jurgen.klinsmann@gmail.com");
		
		assertTrue(expected.equals(formatted));
	}
	
	@Test
	public void test() {
		
		String formatted = JsonBuild.jsonFormat("name", "Jurgen Klinsmann" 
				, "email", "jurgen.klinsmann@gmail.com"
				, "birthDate", "30/06/1994"
				, "document", "12345678"
				, "creditCard", "9999999-9"
				, "phones:" , "+49 391392939");
		
		System.out.println(formatted);
	}

}
