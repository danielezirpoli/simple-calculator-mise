# Gradle
Build with Gradle
## Build with Gradle
The gradle build command will generate the jar package in ./build/libs/
```
gradle clean build
```
# Docker
Build and run with Docker
## Build with Dockerfile
```
docker build --no-cache --progress=plain -t ms-calculator .
```
## Build with Buildpacks
Spring Boot 2.3 added support for buildpacks. Put simply, instead of creating our own Dockerfile and building it using something like docker build, all we have to do is issue the following command:
```
gradle bootBuildImage
```
```
mvn spring-boot:build-image
```
## List images
```
docker image ls --all
```
## Remove unused images
```
docker image prune
```
## Run with Docker
```
docker run --publish 8081:8080 ms-calculator
```

### Run with Docker in detached mode
```
docker run -d --publish 8081:8080 --name my-ms-calculator ms-calculator
```

If we run the container in detached mode, we can inspect its details, stop it, and remove it with the following commands:
```
docker inspect calculator
```
```
docker container ls --all
```
```
docker stop <contained-id>
```
```
docker stop mycalculator
```
```
docker container prune
```
```
docker rm mycalculator
```
# Docker Compose
## Check Compose
Check docker-compose.yml for syntax-errors:
```
docker-compose config
```

## Run with Compose
This will start up the service
```
docker-compose up -d --build --scale my-calculator=3 
```
This will list running service
```
docker-compose ps
```
This will stop containers
```
docker-compose down
```

# Call endpoint
```
curl --location 'http://localhost:8081/calculator/sum' \
--header 'Content-Type: application/json' \
--data '{
    "factors": [1.4, 3.2, 6]
}'
```