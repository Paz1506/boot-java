
    GET http://localhost:8080/api
    GET http://localhost:8080/api/users
    GET http://localhost:8080/api/users/1
    GET http://localhost:8080/api/users/search
    GET http://localhost:8080/api/users/search/by-email?email=User@gmail.com
    GET http://localhost:8080/api/users/search/by-lastname?lastName=Admin
    GET http://localhost:8080/api/users/search/by-lastname?lastName=last

    POST http://localhost:8080/api/users
    Content-Type: application/json

    {
     "email": "test@test.com",
     "firstName": "Test",
     "lastName": "Test",
     "password": "test",
     "roles": [ "ROLE_USER"]
    }

    ###
    PATCH http://localhost:8080/api/users/1
    Content-Type: application/json

    {
      "lastName": "User+Last"
    }

