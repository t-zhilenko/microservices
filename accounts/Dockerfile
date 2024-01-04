#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information about who maintains the image
MAINTAINER frank.com

#Add the applications  jar file to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#Command to execute the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]