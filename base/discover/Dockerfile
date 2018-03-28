FROM java:8

RUN mkdir /app
WORKDIR /app
COPY build/libs/discover.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/discover.jar", "--spring.profiles.active=default"]
EXPOSE 8761