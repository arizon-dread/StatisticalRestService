FROM openjdk:13-ea-9-jdk-alpine3.9

EXPOSE 8081:8080
CMD mkdir /opt/StatisticalRestService
COPY target/StatisticalRestService-0.0.1-SNAPSHOT.jar /opt/StatisticalRestService
COPY DockerConfig/application.yml /opt/StatisticalRestService
CMD chmod +x /opt/StatisticalRestService/StatisticalRestService-0.0.1-SNAPSHOT.jar
CMD java -jar -Dspring.config.location=/opt/StatisticalRestService/application.yml /opt/StatisticalRestService/StatisticalRestService-0.0.1-SNAPSHOT.jar