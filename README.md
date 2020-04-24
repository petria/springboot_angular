# Springboot backend + Angular SPA demo

Pre-requisites to build:

### For Java:

- JDK14

- Apache Maven

### For Angular frontend:

- NPM

- NG (angular cli)

### After checkout install node dependencies

cd src/main/resources/frontend/angular-app/ && npm install && cd -  

### After that build Springboot app normally

mvn package

## Run application using H2 memory database

#### java -jar target/books-0.0.1-SNAPSHOT.jar

## Run application using MariaDB

- db settings in application-mariadb.properties
- db running in localhost
- user: test / passsword: test
- database: books 

#### java -jar -Dspring.profiles.active=mariadb target/books-0.0.1-SNAPSHOT.jar

## Application is available http://localhost:8080/
 