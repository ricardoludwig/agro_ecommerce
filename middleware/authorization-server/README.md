
curl -X POST 'localhost:7002/oauth/token?grant_type=password&username=lud&password=123456' -H 'ContentType: application/json' -H 'Authorization:Basic bWFzdGVydG9rZW46JDJhJDEwJHRybXdqUFVaRzNXZjBzaE1tN0w3MnU5ZzhBMlFOOEJMOUFabFoydU94L3ZVQTBlTG16ZTQu' -v && echo



mastertoken:$2a$10$trmwjPUZG3Wf0shMm7L72u9g8A2QN8BL9AZlZ2uOx/vUA0eLmze4.


auth_db=> GRANT ALL PRIVILEGES ON TABLE authority TO lud;
GRANT
auth_db=> GRANT ALL PRIVILEGES ON TABLE oauth_access_token TO lud;
GRANT
auth_db=> GRANT ALL PRIVILEGES ON TABLE oauth_client_details TO lud;
GRANT
auth_db=> GRANT ALL PRIVILEGES ON TABLE oauth_refresh_token TO lud;
GRANT
auth_db=> GRANT ALL PRIVILEGES ON TABLE user_authority TO lud;


curl -X POST 'localhost:7003/oauth/token?grant_type=password&username=admin@teste.com.br&password=123456' -H 'ContentType: application/json' -H 'Authorization:Basic bWFzdGVydG9rZW46JDJhJDEwJHRybXdqUFVaRzNXZjBzaE1tN0w3MnU5ZzhBMlFOOEJMOUFabFoydU94L3ZVQTBlTG16ZTQu' -v && echo


curl -X POST 'localhost:7003/user' -H 'ContentType: application/json' -H 'Authorization:Bearer b18c3fc9-0dff-4274-ba77-4e7e64740d73' -v && echo


---ricardoludwig-auth-server.herokuapp.com


curl -X POST 'ricardoludwig-auth-server.herokuapp.com/oauth/token?grant_type=password&username=admin@teste.com.br&password=123456' -H 'ContentType: application/json' -H 'Authorization:Basic bWFzdGVydG9rZW46JDJhJDEwJHRybXdqUFVaRzNXZjBzaE1tN0w3MnU5ZzhBMlFOOEJMOUFabFoydU94L3ZVQTBlTG16ZTQu' -v && echo

curl -X POST 'ricardoludwig-auth-server.herokuapp.com/user' -H 'ContentType: application/json' -H 'Authorization:Bearer ca8a0bb3-a121-42fd-b895-32310e4e5945' -v && echo


8430e56a-4a8f-4cf8-97ff-4ad078f41d2b
