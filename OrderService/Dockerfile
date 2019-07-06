FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/OrderService.jar OrderServiceDocker.jar
ENV JAVA_OPTS=""
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "OrderServiceDocker.jar"]