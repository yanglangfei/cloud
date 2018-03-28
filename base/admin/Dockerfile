FROM java:8

RUN mkdir /app
WORKDIR /app
COPY build/libs/admin.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/admin.jar", "--spring.profiles.active=default"]
EXPOSE 8855