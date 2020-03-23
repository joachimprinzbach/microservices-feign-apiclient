FROM openjdk:8-jre-alpine
RUN mkdir /opt/app/
ADD target/*.jar /opt/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]