FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /build

COPY gateway-service/src gateway-service/src
COPY gateway-service/pom.xml gateway-service/pom.xml
COPY book-service/src book-service/src
COPY book-service/pom.xml book-service/pom.xml
COPY loan-service/src loan-service/src
COPY loan-service/pom.xml loan-service/pom.xml
COPY pom.xml pom.xml

RUN mvn -pl gateway-service clean package -DskipTests


FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /build/gateway-service/target/*.jar gateway-service.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]