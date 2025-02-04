# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file from the host machine to the container
COPY target/flightreservation-0.0.1-SNAPSHOT.jar flightreservation.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "flightreservation.jar"]