FROM openjdk:8-jre-alpine
RUN mkdir /opt/app/
ADD target/*.jar /opt/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]





FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=MAVEN_BUILD /build/target/docker-boot-intro-0.1.0.jar /app/