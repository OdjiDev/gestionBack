
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY target/Spring_Back_end-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]

