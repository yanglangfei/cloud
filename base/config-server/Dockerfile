FROM java:8

RUN mkdir /app
WORKDIR /app
COPY build/libs/config-server.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/config-server.jar", "--spring.profiles.active=default"]
EXPOSE 8888