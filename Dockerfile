# Stage 1: build the jar
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# copy maven wrapper/ settings + pom first to leverage layer cache
COPY pom.xml mvnw .mvn/ ./
# copy source
COPY src ./src

# Build (skip tests to speed up). If you want tests, remove -DskipTests.
RUN mvn -B -DskipTests package

# Stage 2: runtime image
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# copy the built jar from previous stage (pattern may vary by your artifactId)
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
