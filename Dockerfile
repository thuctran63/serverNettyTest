# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy Gradle files first for caching dependencies
COPY gradle gradle
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .

# Grant execution permission for the Gradle wrapper
RUN chmod +x ./gradlew

# Build the application
RUN ./gradlew build --no-daemon

# Copy the application JAR file
COPY build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
