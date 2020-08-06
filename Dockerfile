FROM openjdk:8-jdk-alpine
ADD target/*.jar ProjectService-0.0.1-SNAPSHOT.jar
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "ProjectService-0.0.1-SNAPSHOT.jar"]