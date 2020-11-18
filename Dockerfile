FROM openjdk:11-jre-slim
EXPOSE 8080
ARG JAR_FILE=target/stoom-address-app-1.0.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]