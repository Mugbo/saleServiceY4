FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/saleservice-0.0.1-SNAPSHOT.jar /app

EXPOSE 8082

CMD ["java", "-jar", "saleservice-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]