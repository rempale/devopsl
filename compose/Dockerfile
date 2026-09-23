FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn -B clean package -DskipTests \
    && mv target/*.jar app.jar

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]