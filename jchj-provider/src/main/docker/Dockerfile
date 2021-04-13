FROM java:8
VOLUME /tmp
ADD jchj-provider.jar app.jar
EXPOSE 8001
RUN bash -c 'touch /app.jar'
ENTRYPOINT  ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
