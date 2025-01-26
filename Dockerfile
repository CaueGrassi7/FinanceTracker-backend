FROM eclipse-temurin:21-jre
ARG JAR_FILE=target/financetracker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
