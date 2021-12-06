FROM openjdk:11
#FROM java:11
VOLUME /tmp
EXPOSE 80
COPY target/gateway-0.0.1-SNAPSHOT.jar app.jar
#CMD nohup sh -c "java -jar /app.jar --spring.profiles.active=prod"
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=prod"]