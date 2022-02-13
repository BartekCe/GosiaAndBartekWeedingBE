FROM adoptopenjdk/openjdk11:latest

COPY target/gosia-bartek-RoadToWeeding-0.0.1-SNAPSHOT.jar gosia-bartek-RoadToWeeding-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/gosia-bartek-RoadToWeeding-0.0.1.jar"]
