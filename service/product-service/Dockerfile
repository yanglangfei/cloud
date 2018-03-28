FROM java:8

RUN mkdir /app
WORKDIR /app
COPY build/libs/product-service.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/product-service.jar", "--spring.profiles.active=default"]
EXPOSE 1003