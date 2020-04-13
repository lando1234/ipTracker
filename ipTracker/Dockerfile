FROM openjdk:8-jdk-alpine
WORKDIR /opt/app
ARG JAR_FILE=target/ipTracker-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
