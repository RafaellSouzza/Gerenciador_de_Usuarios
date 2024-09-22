FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/UsuariosAPI-0.0.1-SNAPSHOT.jar usuarios-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "usuarios-api.jar"]
