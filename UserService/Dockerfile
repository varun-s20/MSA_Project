FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/UserService-0.0.1-SNAPSHOT.jar /app/UserService.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/UserService.jar"]