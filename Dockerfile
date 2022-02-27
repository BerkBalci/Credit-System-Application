FROM openjdk:8-jdk-alpine

MAINTAINER Berk Balcı <berkbalci1234@gmail.com>
EXPOSE 8080
ADD target/Credit-System-0.0.1-SNAPSHOT.jar Credit-System.jar

ENTRYPOINT ["java","-jar","Credit-System.jar"]

