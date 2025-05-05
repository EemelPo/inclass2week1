# Use Maven to build the project
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src
# Build the project and package the jar (skipping tests for faster builds)
RUN mvn clean package -DskipTests

# Use a minimal OpenJDK image to run the application
FROM openjdk:21-jdk-slim
WORKDIR /app
# Copy the packaged jar from the builder stage
COPY --from=build /app/target/inclass2week1-1.0-SNAPSHOT.jar app.jar
# Expose a port if needed
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]