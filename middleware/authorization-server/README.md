
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


curl -X POST 'localhost:7003/oauth/token?grant_type=password&username=admin&password=123456' -H 'ContentType: application/json' -H 'Authorization:Basic bWFzdGVydG9rZW46JDJhJDEwJHRybXdqUFVaRzNXZjBzaE1tN0w3MnU5ZzhBMlFOOEJMOUFabFoydU94L3ZVQTBlTG16ZTQu' -v && echo


curl -X POST 'localhost:7002/oauth/token?grant_type=password&username=jurgen.klinsmann@gmail.com&password=123456' -H 'ContentType: application/json' -H 'Authorization:Basic bWFzdGVydG9rZW46JDJhJDEwJHRybXdqUFVaRzNXZjBzaE1tN0w3MnU5ZzhBMlFOOEJMOUFabFoydU94L3ZVQTBlTG16ZTQu' -v && echo


curl -X POST 'localhost:7002/user' -H 'ContentType: application/json' -H 'Authorization:Bearer 7f8ebe12-6b7a-4680-87bc-007f5138cb5f' -v && echo

curl -X POST 'localhost:7003/user' -H 'ContentType: application/json' -H 'Authorization:Bearer ec683715-a3af-4b30-9fd3-a3454e6953dc' -v && echo



---ricardoludwig-as.herokuapp.com


curl -X POST 'ricardoludwig-as.herokuapp.com/oauth/token?grant_type=password&username=admin&password=123456' -H 'ContentType: application/json' -H 'Authorization:Basic bWFzdGVydG9rZW46JDJhJDEwJHRybXdqUFVaRzNXZjBzaE1tN0w3MnU5ZzhBMlFOOEJMOUFabFoydU94L3ZVQTBlTG16ZTQu' -v && echo

curl -X POST 'ricardoludwig-as.herokuapp.com/user' -H 'ContentType: application/json' -H 'Authorization:Bearer 8430e56a-4a8f-4cf8-97ff-4ad078f41d2b' -v && echo


8430e56a-4a8f-4cf8-97ff-4ad078f41d2b
