FROM openjdk:8
EXPOSE 8081
RUN mkdir -p /app/
ADD /build/libs/fitBank-0.0.1-SNAPSHOT.jar /app/fitBank-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/fitBank-0.0.1-SNAPSHOT.jar"]