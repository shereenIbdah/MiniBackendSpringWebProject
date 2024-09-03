FROM openjdk:17-jdk-alpine
EXPOSE 8222
ADD target/gateway.jar gateway.jar
ENTRYPOINT ["java", "-jar", "/gateway.jar"]