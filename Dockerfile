FROM java:8-jre
ADD ./target/MovieMongo-0.0.1-SNAPSHOT.jar /usr/src/MyMovieMongo-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","MyMovieMongo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8075