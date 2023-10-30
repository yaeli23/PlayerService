# Use the official Maven image as the base image
FROM maven:3.8.3-openjdk-17-slim

# Copy the source code to the container
COPY . /app

# Set the working directory
WORKDIR /app

# Build the application
RUN mvn clean package

# Expose the port that Spring Boot application runs on
EXPOSE 8080

# The command to run the application
CMD ["mvn", "spring-boot:run"]
