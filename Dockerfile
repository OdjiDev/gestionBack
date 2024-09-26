# Étape 1 : Construire le projet Maven
#FROM maven:3.8.3-openjdk-17 AS build
#COPY . /app
#WORKDIR /app
#RUN mvn clean package -DskipTests

# Étape 2 : Exécuter l'application
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY target/Spring_Back_end-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              