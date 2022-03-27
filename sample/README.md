# Java Starter #

## Microservice sample application

### Prerequisites
- Java 11 JDK
- Maven
- Docker
- Postman
- NodeJS 16

### Build and run

#### Microservices
Bitte jeweils in einem eigenen Terminal in den Unterverzeichnissen `person`, `auftrag` und `shop` ausführen:
```shell
mvn clean install docker:run
```
iIn jedem Terminal läuft dann ein Microservice.

#### Frontend

```shell
npm start
```

### Vorbereitung frontend

Einmalig auszuführen:
- install Node.js: https://nodejs.org
- install Angular: `npm install -g @angular/cli`
- install dependencies: `npm install`

