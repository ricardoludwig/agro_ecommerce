

Gerando o token:
---------------

curl -X POST 'ricardoludwig-auth-server.herokuapp.com/oauth/token?grant_type=password&username=admin@teste.com.br&password=123456' -H 'ContentType: application/json' -H 'Authorization:Basic bWFzdGVydG9rZW46JDJhJDEwJHRybXdqUFVaRzNXZjBzaE1tN0w3MnU5ZzhBMlFOOEJMOUFabFoydU94L3ZVQTBlTG16ZTQu' && echo


Criando cliente:
---------------

curl -i -d '{"name":"Video Teste","email":"video4@teste.com","login":"video4@teste.com","birthDate":"30/06/1994","document":"69569178078","typeOfDocument":"CPF","creditCard":"9999999-9","phones":"+49 391392939"}' -H "Content-Type: application/json" -H 'Authorization:Bearer 272e205e-e0f2-4a17-94e6-cae8916cf4c6' POST https://ricardoludwig-customer-domain.herokuapp.com/customer && echo

Token inválido
---------------

curl -H "Content-Type: application/json" -H 'Authorization:Bearer fda79936-379f-49c6-a622-de0c821b8695' -X GET https://ricardoludwig-customer-domain.herokuapp.com/customer?login=video4@teste.com && echo


Consultando dados do cliente criado:
------------------------------------

curl -H "Content-Type: application/json" -H 'Authorization:Bearer 272e205e-e0f2-4a17-94e6-cae8916cf4c6' -X GET https://ricardoludwig-customer-domain.herokuapp.com/customer?login=video4@teste.com && echo


Criando usuário do sistema:
---------------------------

curl -i -d '{"username":"video4@teste.com","password":"123456"}' -H "Content-Type: application/json" -X POST https://ricardoludwig-user-domain.herokuapp.com/user && echo


Acessando o catalogo de produtos com o novo usuário criado:
-----------------------------------------------------------

https://ricardoludwig-zuul-server.herokuapp.com/catalog


Carregando o contrato WSDL do Web Service para envio de orçamento:
---------------------------------------------------------------------

https://ricardoludwig-quotation-domain.herokuapp.com/ws/products.wsdl


Fazendo o envio do orçamento
-----------------------------

curl --header "content-type: text/xml" -d @request.xml http:///ricardoludwig-quotation-domain.herokuapp.com/ws

Acessando o Eureka:
---------------------------------------------------------------------

https://ricardoludwig-eureka-server.herokuapp.com/












