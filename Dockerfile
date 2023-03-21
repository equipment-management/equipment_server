FROM openjdk:11-ea-11-jdk-slim
WORKDIR /app/equipment
EXPOSE 2542
COPY build/libs/equipment-0.0.1.jar Equipment.jar
ENTRYPOINT ["java", "-jar", "Equipment.jar"]