# Java Starter #

## Step 15

Build mit Maven

### Prerequisites
- Java 17 JDK
- Maven

Prüfung mit:
```shell
mvn -version
```

Erwartetes Ergebnis (Beispiel):
```shell
Apache Maven 3.9.1 (2e178502fcdbffc201671fb2537d0cb4b4cc58f8)
Maven home: /Users/georg/jee/seu/maven
Java version: 17.0.6, vendor: Eclipse Adoptium, runtime: /Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home
Default locale: de_DE, platform encoding: UTF-8
OS name: "mac os x", version: "13.1", arch: "x86_64", family: "mac"
```

### Build and run

```shell
mvn clean package
java -classpath target/starter-1.0-SNAPSHOT.jar de.conciso.starter.HelloWorld
```
