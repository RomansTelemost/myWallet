FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar myWallet-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/myWallet-0.0.1.jar"]