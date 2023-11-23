# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./target/TopData-1.1.3-TESTEDATA.jar /app/TopData-1.1.3-TESTEDATA.jar

CMD ["java", "-jar", "TopData-1.1.3-TESTEDATA.jar"]

EXPOSE 8080