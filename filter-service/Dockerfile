FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/app.jar"]