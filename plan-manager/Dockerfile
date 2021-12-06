FROM openjdk:11
#FROM java:11
VOLUME /tmp
EXPOSE 7772
COPY target/plan-manager-0.0.1-SNAPSHOT.jar app.jar
#CMD nohup sh -c "java -jar /app.jar --spring.profiles.active=prod"
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=prod"]