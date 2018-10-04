package br.com.ricardoludwig.customer.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.ricardoludwig.customer.model.CPF;
import br.com.ricardoludwig.customer.model.NaturalPerson;
import br.com.ricardoludwig.customer.service.CustomerService;
import br.com.ricardoludwig.customer.util.JsonBuild;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService service;
	
	@MockBean
	private DiscoveryClient discoveryClient; 
	
	@Test
	public void createOneTest() throws Exception {
		
		when(service.createOne(any())).thenReturn(buildNaturalPerson());

		mockMvc.perform(
				(post("/customer").contentType(MediaType.APPLICATION_JSON).content(customerDataJson())))
					.andDo(print())
					.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void createOneWhenGiveCustomerWithoutEmailThenReturnBadRequestTest() throws Exception {

		when(service.createOne(any())).thenReturn(buildNaturalPerson());
		
		mockMvc.perform(
				(post("/customer").contentType(MediaType.APPLICATION_JSON).content(customerDataWithoutEmailJson())))
					.andDo(print())
					.andExpect(status().isBadRequest());
	}

	@Test
	public void createOneWhenGiveCustomerInvalidEmailThenReturnBadRequestTest() throws Exception {
		
		when(service.createOne(any())).thenReturn(buildNaturalPerson());

		mockMvc.perform(
				(post("/customer").contentType(MediaType.APPLICATION_JSON).content(customerDataJsonWithInvalidEmail())))
					.andDo(print())
					.andExpect(status().isBadRequest());
	}
	
	@Test
	public void readOneTest() throws Exception {
		
		when(service.findBy(anyString())).thenReturn(buildNaturalPerson());

		String queryFindByLogin = "/customer?login=jurgen.klinsmann@gmail.com";
		mockMvc.perform(
				get(queryFindByLogin))
					.andDo(print())
					.andExpect(status().isOk());
	}

	@Test
	public void updateOneTest() throws Exception {
		
		when(service.updateOne(any())).thenReturn(buildNaturalPerson());

		mockMvc.perform(
				(put("/customer").contentType(MediaType.APPLICATION_JSON).content(customerDataJson())))
					.andDo(print())
					.andExpect(status().isOk());
	}

	@Test
	public void deleteOneByIdTest() throws Exception {
		
		when(service.disableBy(anyString())).thenReturn(buildNaturalPerson());

		mockMvc.perform(
				delete("/customer/jurgen.klinsmann@gmail.com"))
					.andDo(print())
					.andExpect(status().isOk());

	}
	
	private String customerDataJson() {
		
		String formatted = JsonBuild
				.jsonFormat("name", "Jurgen Klinsmann" 
						, "email", "jurgen.klinsmann@gmail.com"
						, "login", "jurgen.klinsmann@gmail.com"
						, "birthDate", "30/06/1994"
						, "document", "69569178078"
						, "typeOfDocument", "CPF"
						, "creditCard", "9999999-9"
						, "phones", "+49 391392939");
		
		return formatted;
		
	}
	
	private String customerDataJsonWithInvalidEmail() {
		
		String formatted = JsonBuild
				.jsonFormat("name", "Jurgen Klinsmann" 
						, "email", "jurgen.klinsmanngmail.com"
						, "login", "jurgen.klinsmann@gmail.com"
						, "birthDate", "30/06/1994"
						, "document", "69569178078"
						, "creditCard", "9999999-9"
						, "phones", "+49 391392939");
		
		return formatted;
		
	}
	
	private String customerDataWithoutEmailJson() {
		
		String formatted = JsonBuild
				.jsonFormat("name", "Jurgen Klinsmann" 
						, "birthDate", "30/06/1994"
						, "login", "jurgen.klinsmann@gmail.com"
						, "document", "69569178078"
						, "typeOfDocument", "CPF"
						, "creditCard", "9999999-9"
						, "phones", "+49 391392939");
		
		return formatted;
	}
		
	private NaturalPerson buildNaturalPerson() {

		return new NaturalPerson.Builder().login("jurgen.klinsmann@gmail.com")
				.email("jurgen.klinsmann@gmail.com")
				.document(new CPF("69569178078"))
				.name("Jurgen Klinsmann")
				.phone("+49 391392939")
				.creditCard("xx")
				.builder();

	}

}