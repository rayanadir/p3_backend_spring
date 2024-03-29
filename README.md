# Java Spring Boot MySQL Application

## Prerequisites
Make sure you've installed:

* Java Development Kit (JDK) - version 11 or 17
* MySQL
* Maven - install your dependencies
* Code editor - IntelliJ is recommended

## Configuration
* First of all, declare properties in your `application.yml` file in the `src/main/resources` directory.

* Add the following properties :

```yml
spring:
    datasource:
        url: jdbc:mysql://localhost:3306/your_database_name
        username: your_database_username
        password: your_database_password
```
Note: Always respect the indentation in a yml file !
Change `your_database_name`, `your_database_username` and `your_database_password` by your actual MySQL properties

### Run the application
* Install maven dependencies:
```
mvn clean install
```

* Build and run the application: 
```
mvn spring-boot:run
```

## Create the database
* Open your MySQL CLI and enter your password, run the following command :

``` SQL
CREATE DATABASE your_database_name;
```
Run the following commands in this [file](https://github.com/rayanadir/Developpez-le-back-end-en-utilisant-Java-et-Spring/blob/main/ressources/sql/script.sql) to create tables

## API Documentation
* Swagger link: http://localhost:3001/swagger-ui/index.html

## Client repository
* Run the following commands to install the client :
```
git fork https://github.com/rayanadir/Developpez-le-back-end-en-utilisant-Java-et-Spring
```

```
git clone your__forked_github_repository
```