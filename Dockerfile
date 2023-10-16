FROM gradle:8.3-jdk17 as builder

ENV APP_DIR /app
WORKDIR $APP_DIR

COPY . .
RUN gradle build

FROM openjdk:17-slim-buster
WORKDIR $APP_DIR
EXPOSE 8080
COPY --from=builder /app/build/libs/pt-iotsens-0.1.0.jar .
CMD java -jar topbrawl-api-0.1.0.jar

