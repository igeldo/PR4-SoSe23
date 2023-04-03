# Java Starter #

## Step 90

Store data with Spring Data in PostgreSQL

### Prerequisites
- Java 17 JDK
- Maven
- Docker

### Build and run

```shell
docker-compose -f docker/src/test/docker/docker-compose.yml up
mvn clean package spring-boot:run
```

Open in browser:
- http://localhost:8080/createPerson.html
- http://localhost:8080/findPerson.html
