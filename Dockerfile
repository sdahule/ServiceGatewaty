FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
VOLUME /tmp
EXPOSE 1000
COPY ${JAR_FILE} servicegateway.jar
ENTRYPOINT ["java","-jar","servicegateway.jar"]