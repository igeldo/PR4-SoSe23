# Java Starter #

## Step 15

Build mit Maven

### Prerequisites
- Java 11 JDK
- Maven

Prüfung mit:
```shell
mvn -version
```

Erwartetes Ergebnis (Beispiel):
```shell
Apache Maven 3.8.5 (3599d3414f046de2324203b78ddcf9b5e4388aa0)
Maven home: /Users/georg/jee/seu/maven
Java version: 11.0.13, vendor: Eclipse Adoptium, runtime: /Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home
Default locale: de_DE, platform encoding: UTF-8
OS name: "mac os x", version: "10.15.7", arch: "x86_64", family: "mac"
```

### Build and run

```shell
mvn clean package
java -classpath target/starter-1.0-SNAPSHOT.jar de.conciso.starter.HelloWorld
```
