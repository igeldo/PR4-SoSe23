# Java Starter #

## Step 110

Secure service with Spring Security and Keycloak

### Prerequisites
- Java 17 JDK
- Maven
- Docker
- Postman

### Build and run

```shell
mvn clean install docker:run
```

Open in browser: 
- http://localhost:8080/createPerson.html
- http://localhost:8080/findPerson.html
- use Postman!

### Keycloak configuration

- Realm: `java-starter-realm`
- Client ID: `java-starter-client`
- Role: `user`
- Username: `java-starter-user`
- Password: `passKeycloakUser`

#### Keycloak admin user

- Username: `admin`
- Password: `passKeycloakAdmin`
- Admin console: http://localhost:8081/auth/admin/master/console/#/realms/java-starter-realm
