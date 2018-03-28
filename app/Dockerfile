FROM java:8

RUN mkdir /app
WORKDIR /app
COPY build/libs/app.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar", "--spring.profiles.active=default"]
EXPOSE 8088