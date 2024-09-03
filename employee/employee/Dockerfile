FROM openjdk:17-jdk-alpine
EXPOSE 8090
ADD target/employee.jar employee.jar
ENTRYPOINT ["java", "-jar", "/employee.jar"]