#
#FROM maven:3.8.3-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests
#From openjdk:17.0.1-jdk-slim
#COPY --from=build /target/Spring_Back_end-0.0.1-SNAPSHOT.jar backend.jar
#EXPOSE 8080
#ENTRYPOINT ("java","-jar","backend.jar")

# Étape 1 : Construire le projet Maven
FROM maven:3.8.3-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Étape 2 : Exécuter l'application
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /app/target/Spring_Back_end-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]
