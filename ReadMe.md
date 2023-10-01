# springsecurity-api-jwt-pidev-roles
springsecurity-api-jwt-springboot-waf-with-roles


![project architecture](https://i.imgur.com/IdPmENX.png)

<br/> 

![XDA](https://i.imgur.com/XBqmStJ.png)
![ssdf](https://i.imgur.com/Rprk7Lx.png)

<br/>
<br/>
<br/>

----



<br/>
<br/>


```
http://localhost:8080/dashboard
```


<br/>

![charts](https://i.imgur.com/5niywyM.png)


<br/>
<br/>
<br/>
<br/>

---

---

<br/>
<br/>
<br/>

# HTTP Methods in PostMan with Examples : 


In Postman, you can send HTTP requests with various methods and attach JSON data to the requests when necessary. Here are the previous examples with Postman-specific details for sending JSON data:

### Spring Boot API Postman Examples

This README provides examples of using Postman to interact with a Spring Boot API that manages a hypothetical "user" resource.

## GET Example (Retrieve a List of Users)

- **Request Method**: GET
- **URL**: `http://localhost:8080/api/users`

## GET Example (Retrieve a Specific User by ID)

- **Request Method**: GET
- **URL**: `http://localhost:8080/api/users/1`

## POST Example (Create a New User)

- **Request Method**: POST
- **URL**: `http://localhost:8080/api/users`
- **Body (Raw JSON)**:
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "johndoe@example.com"
  }
 

##  PUT Example (Update an Existing User by ID)
- **Request Method**: PUT
- **URL**: `http://localhost:8080/api/users/1`
- **Body (Raw JSON)**:
 ```json
{
  "firstName": "UpdatedJohn",
  "lastName": "UpdatedDoe",
  "email": "updatedjohndoe@example.com"
} 
```

## DELETE Example (Delete an Existing User by ID)
- **Request Method**: DELETE
- **URL**: `http://localhost:8080/api/users/1`

In Postman, set the request method (GET, POST, PUT, DELETE) and provide the request URL as shown above. For POST and PUT requests, 
include a JSON body with the data to send to the server. Ensure that the "Content-Type" header is set to "application/json" when sending JSON data.

These examples demonstrate how to perform different HTTP methods with JSON data for a user resource in your Spring Boot API.
