FROM java:8
VOLUME /tmp
ADD jchj-consumer.jar app.jar
EXPOSE 9104
RUN bash -c 'touch /app.jar'
ENTRYPOINT  ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
