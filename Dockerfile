FROM gradle:8.4.0-jdk17-alpine as build_step
COPY ./src ./src
COPY build.gradle ./
COPY settings.gradle ./
RUN gradle clean bootJar
ENTRYPOINT java -jar ./build/libs/$(ls ./build/libs/)