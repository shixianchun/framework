FROM java:8
VOLUME /tmp
ADD jchj-gateway.jar app.jar
EXPOSE 9100
RUN bash -c 'touch /app.jar'
ENTRYPOINT  ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
