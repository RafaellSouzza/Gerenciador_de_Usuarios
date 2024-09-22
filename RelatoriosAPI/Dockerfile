FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/RelatoriosAPI-0.0.1-SNAPSHOT.jar relatorios-api.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "relatorios-api.jar"]
