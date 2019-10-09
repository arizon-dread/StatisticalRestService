FROM openjdk:13-ea-9-jdk-alpine3.9
EXPOSE 8080
CMD mkdir /opt/StatisticalRestService
COPY target/StatisticalRestService-0.0.1-SNAPSHOT.jar /opt/StatisticalRestService/
COPY DockerConfig/application.yml /opt/StatisticalRestService/
RUN chmod 777 /opt/StatisticalRestService/StatisticalRestService-0.0.1-SNAPSHOT.jar
#\
#&& ls -l /opt/StatisticalRestService/StatisticalRestService-0.0.1-SNAPSHOT.jar \
#&& INTERNAL_HOST_IP=$(ip route show default | awk '/default/ {print $3}') \
#&& echo "$INTERNAL_HOST_IP  host.docker.internal" >> /etc/hosts \
#&& chmod +r /etc/hosts \
#&& cat /etc/hosts
ENTRYPOINT [ "java", "-jar", "-Dspring.config.location=/opt/StatisticalRestService/application.yml", "/opt/StatisticalRestService/StatisticalRestService-0.0.1-SNAPSHOT.jar" ]  