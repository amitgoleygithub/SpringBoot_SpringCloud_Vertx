FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/BillingService.jar BillingServiceDocker.jar
ENV JAVA_OPTS=""
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "BillingServiceDocker.jar"]