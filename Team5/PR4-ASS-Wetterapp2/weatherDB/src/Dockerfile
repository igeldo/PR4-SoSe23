FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/your-spring-app.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
