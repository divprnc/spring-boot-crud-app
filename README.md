 Spring Boot CRUD Application

Spring Boot CRUD Application
============================

This is a simple Spring Boot CRUD application with all the functionalities of the CRUD operations using MySQL. The application uses the following libraries:

*   Spring Boot Starter Actuator
*   Spring Boot Starter Validation
*   Model Mapper
*   MySQL Connector
*   Spring Boot Started Data JPA

Version Information
-------------------

The following versions have been used in the development of this application:

*   Spring: 3.0.2
*   Java Version: 17

Functionalities
---------------

The following functionalities have been implemented in the application:

*   CRUD Application to create User
*   Handling Different Exceptions
*   REST Endpoint for all CRUD Operations

Getting Started
---------------

The following steps will guide you on how to set up the development environment and run the application.

### Prerequisites

*   Java 17
*   MySQL Database

### Installing

1.  Clone the repository to your local machine.
2.  Import the project into your preferred IDE.
3.  Install the required dependencies and libraries.
4.  Update the application.properties file with your MySQL database credentials.
5.  Run the application as a Spring Boot application.

Usage
-----

The REST endpoint for all CRUD operations is exposed at `http://localhost:8080/api/users`. The endpoint supports the following operations:

*   Create a User: `POST` request to `/api/users` with a JSON request body containing the user details.
*   Read a User: `GET` request to `/api/users/{id}` where `{id}` is the id of the user to be read.
*   Update a User: `PUT` request to `/api/users/{id}` where `{id}` is the id of the user to be updated and the JSON request body contains the updated user details.
*   Delete a User: `DELETE` request to `/api/users/{id}` where `{id}` is the id of the user to be deleted.

Error Handling
--------------

The application has been configured to handle different exceptions that may occur during the execution of the CRUD operations. If an error occurs, a meaningful error message will be returned to the client in a JSON format.

Conclusion
----------

This application demonstrates the basic CRUD operations using Spring Boot and MySQL. It can be used as a starting point for developing more complex applications.
