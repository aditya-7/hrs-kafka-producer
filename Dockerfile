FROM openjdk:8-alpine
LABEL maintainer="aditya.kishore@ltts.com"
WORKDIR /hrs-kafka-producer
COPY target/hrs-kafka-producer-1.0.0-jar-with-dependencies.jar producer.jar
ENTRYPOINT ["java", "-jar", "producer.jar"]
