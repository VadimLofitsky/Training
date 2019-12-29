# Dockerfile for building the web-app image

FROM openjdk:12-alpine

WORKDIR /usr/dev/BookStoreExample/lib

# Copy jar to work dir inside the container
COPY book-store-example-1.0-SNAPSHOT.jar .

ENTRYPOINT ["java"]
CMD ["-jar", "book-store-example-1.0-SNAPSHOT.jar"]
EXPOSE 8080
