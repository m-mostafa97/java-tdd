# Stage 1: Build
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Set working dir
WORKDIR /app

# Copy source code
COPY . .

# Run Maven build
RUN ./mvnw clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy the jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]