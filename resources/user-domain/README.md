User Domain Resource

curl -i -d '{"username":"jurgen.klinsmann@gmail.com","password":"123456"}' -H "Content-Type: application/json" POST http://localhost:8083/user -v && echo


curl -i -d '{"username":"jurgen.klinsmann@gmail.com","password":"123456"}' -H "Content-Type: application/json" POST ricardoludwig-user-domain.herokuapp.com/user -v && echo