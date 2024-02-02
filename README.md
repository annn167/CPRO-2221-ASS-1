# CPRO-2221-ASS-1
This is my Spring Boot application in Java that implements CRUD (Create, Read, Update, Delete)
operations for a Product entity. 
To run this application you will need to have Postman to show execution of your endpoints.

You have to run the the application using mvn spring-boot:run
post 8080 is in used by another application on my machine so I change the port to 8081
feel free to change it back to the defualt 8080 if it is available in your application.properties
then run the various endpoint in post man

localhost:8081/api/v1/products/create
this endpoint is for creating a new product

http://localhost:8081/api/v1/products/delete/1
this endpoint is for deleting a product the id 1 is just example

http://localhost:8081/api/v1/products/all
this endpoint is for reading all product 

localhost:8081/api/v1/products/update/1
this endpoint is for updating product, you have to pass the product id you want to update for example I use 1 here

