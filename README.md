# Repair Service

This application enables customer to fill in a failure logging form so that the repair service can be used to register customer data and fixed part of his/her product. Then when the repair date comes it creates log info which informs the customer about it.log info which informs customer about it.  

# Prerequisites

* JDK 8+
* Eclipse
* MySQL Community Server 5.7
* Internet browser

# Built With

Project is created with:

* Maven - Dependency Management
* Spring Boot - Used to develop Spring-based Java application 
* Hibernate - Object-relational mapping tool  
* Spring MVC - Provide model-view-controller architecture 
* TomCat Jasper - Server
* Junit - Unit testing 

# Usage

Run the application and go on http://localhost:8080

Use the following urls to invoke controllers methods and see the interactions with the database:

* /repairService: create a new customer with an auto-generated id and contact information
* /findCustomers: find all customers
* /deleteCustomer/{id}: delete customer which has specific id
* findProducts: find all products 
* /findProduct/{name}: find product for a specific customer
* /laptopDetails: save laptop details for a specific customer id 
* /pcDetails: save pc details for a specific customer id
* /mobilePhoneDetails: save mobile phone details for a specific customer id
* /landLinePhoneDetails: save landline phone details for a specific customer id
* /deleteProduct/{id}: delete product which has specific customer id 
  
# Running the tests

- To run test class, the project can be run as JUnit Test 
- Test class will be automatically launched which can be find in src/test/java/com.enginakar.tests folder

# Authors

* Engin Akar

