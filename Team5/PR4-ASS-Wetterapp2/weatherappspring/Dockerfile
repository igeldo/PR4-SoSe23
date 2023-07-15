# Use an official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/weatherappspring-0.0.1-SNAPSHOT.jar app.jar

# Expose port 2345
EXPOSE 2345

# Set the entrypoint command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
