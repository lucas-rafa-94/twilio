FROM openjdk:8
EXPOSE 8083
RUN mkdir -p /app/
ADD /build/libs/twilio-0.0.1-SNAPSHOT.jar /app/twilio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/twilio-0.0.1-SNAPSHOT.jar"]