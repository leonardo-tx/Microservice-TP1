FROM maven:4.0.0-rc-4-eclipse-temurin-21 AS build

WORKDIR /build

COPY book-service/src book-service/src
COPY book-service/pom.xml book-service/pom.xml
COPY loan-service/src loan-service/src
COPY loan-service/pom.xml loan-service/pom.xml
COPY pom.xml pom.xml

RUN mvn -pl book-service clean package -DskipTests


FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /build/book-service/target/*.jar book-service.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "book-service.jar"]