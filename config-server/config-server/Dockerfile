FROM openjdk:17-jdk-alpine
EXPOSE 8888
ADD target/spring-config-docker.jar spring-config-docker.jar
ENTRYPOINT ["java", "-jar", "/spring-config-docker.jar"]