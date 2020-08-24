FROM openjdk
VOLUME /tmp
ADD target/eureka-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 6001
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
