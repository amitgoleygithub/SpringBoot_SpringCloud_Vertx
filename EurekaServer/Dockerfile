FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/EurekaServer.jar EurekaServerDocker.jar
ENV JAVA_OPTS=""

# Docker internal port of container.This container will run on 8761 port
# but this 8761 internal port will not be accessible from outside (from host machine)
# so this external port 8761 need to be bind to external host machine port number when running the container
# docker run -p 8700:8761 image_name   [This will bind internal container port 8761 to  host machine port 8700]
# http://localhost:8700   - then application from host machine can be access
EXPOSE 8761           

    
ENTRYPOINT ["java", "-jar", "EurekaServerDocker.jar"]