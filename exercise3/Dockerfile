FROM debian:bullseye
RUN apt update && apt install -y openjdk-17-jre --fix-missing
COPY target/exercise3-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]