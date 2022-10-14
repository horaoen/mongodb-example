# syntax=docker/dockerfile:1
FROM  williamyeh/java8:latest

MAINTAINER horaoen@gmail.com

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src
CMD ["./mvnw", "spring-boot:run"]

