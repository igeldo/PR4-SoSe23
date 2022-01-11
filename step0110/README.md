# Java Starter #

## Step 110

Secure service with Spring Security and Keycloak

### Prerequisites
- Java 11 JDK
- Maven
- Docker

### Build and run

```shell
mvn clean install docker:run
```

Alternative:
```shell
mvn clean install
docker-compose -f docker/src/test/docker/docker-compose.yml up
```

Open in browser: 
- http://localhost:8080/createPerson.html
- http://localhost:8080/findPerson.html
