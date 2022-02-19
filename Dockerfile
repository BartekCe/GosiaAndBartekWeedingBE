FROM adoptopenjdk/openjdk11:latest

COPY target/gosia-bartek-RoadToWeeding-1.0.0-PROD.jar gosia-bartek-RoadToWeeding-1.0.1-PROD.jar
ENTRYPOINT ["java", "-jar", "/gosia-bartek-RoadToWeeding-1.0.1-PROD.jar"]
