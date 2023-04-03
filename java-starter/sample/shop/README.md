# Java Starter #

## Shop service

### Prerequisites
- Java 11 JDK
- Maven
- Docker
- Postman

### Build and run

```shell
mvn clean install docker:run -Pdocker
```

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
