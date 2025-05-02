# Use JDK 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Create a directory inside the container to hold the app
VOLUME /tmp

# Copy the jar file into the image
COPY target/*.jar app.jar

# Command to run the app
ENTRYPOINT ["java", "-jar", "/app.jar"]