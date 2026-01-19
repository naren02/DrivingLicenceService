FROM eclipse-temurin:11-jre-jammy

WORKDIR /app

ARG JAR_FILE=target/driving-license-api-1.0.0.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-XX:+UseContainerSupport","-jar","app.jar"]
