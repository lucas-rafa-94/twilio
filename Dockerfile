FROM openjdk:8
EXPOSE 8081
RUN mkdir -p /app/
ADD /build/libs/bigBoost-0.0.1-SNAPSHOT.jar /app/bigBoost-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/bigBoost-0.0.1-SNAPSHOT.jar"]