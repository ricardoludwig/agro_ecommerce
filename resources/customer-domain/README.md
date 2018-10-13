REST API Example - Domain Customer
=========================================================================================

	This is a CRUD REST API example to Customer Domain

Setup (TODO):
---------------------------------------------------------------------------------------------------

 
Running maven tests
---------------------------------------------------------------------------------------------------

    customer-domain> mvn test 

Run application locally
---------------------------------------------------------------------------------------------------

     customer-domain> mvn spring-boot:run

Calling API interfaces locally
---------------------------------------------------------------------------------------------------


1- Adding a customer
	
curl -i -d '{"name":"Jurgen Klinsmann","email":"jurgen.klinsmann@gmail.com","login":"jurgen.klinsmann@gmail.com","birthDate":"30/06/1994","document":"69569178078","typeOfDocument":"CPF","creditCard":"9999999-9","phones":"+49 391392939"}' -H "Content-Type: application/json" -H 'Authorization:Bearer 0e3b38cb-0640-4e8c-b4e5-c7814b12ac0e' POST http://localhost:8082/customer -v && echo
	


curl -i -d '{"name":"Jurgen Klinsmann","email":"jurgen.klinsmann@gmail.com","login":"jurgen.klinsmann@gmail.com","birthDate":"30/06/1994","document":"69569178078","typeOfDocument":"CPF","creditCard":"9999999-9","phones":"+49 391392939"}' -H "Content-Type: application/json" POST https://ricardoludwig-customer-domain.herokuapp.com/customer -v && echo	
	
	
2- Invalid Login
	
	curl -i -d '{"name":"Jurgen Klinsmann","email":"jurgen.klinsmann@gmail.com","birthDate":"30/06/1994","document":"12345678","creditCard":"9999999-9","phones:":"+49 391392939"}' -H "Content-Type: application/json" POST http://localhost:7003/customer -v && echo 
	
	
3- Lookup a customer:

	curl GET http://localhost:7003/customer?login=jurgen.klinsmann@gmail.com -v && echo

Calling API interfaces deployed in Heroku
---------------------------------------------------------------------------------------------------


1- Adding a customer
	
	
	
2- Invalid Login
	
	
	
	
3- Lookup a customer:

	



Issue / bug tracking
---------------------------------------------------------------------------------------------------

1. Find customer, javax.persistence.NonUniqueResultException