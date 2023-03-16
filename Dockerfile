FROM docker.io/eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
