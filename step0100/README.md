# Java Starter #

## Step 100

Deploy service as docker container

### Prerequisites
- Java 17 JDK
- Maven
- Docker

### Build and run

```shell
mvn clean install
docker-compose -f docker/src/test/docker/docker-compose.yml up
```

Open in browser: 
- http://localhost:8080/createPerson.html
- http://localhost:8080/findPerson.html
