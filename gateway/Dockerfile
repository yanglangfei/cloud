FROM java:8

RUN mkdir /app
WORKDIR /app
COPY build/libs/gateway.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/gateway.jar", "--spring.profiles.active=default"]
EXPOSE 1101