FROM openjdk:8
LABEL maintainer="piyush.raghuwanshi"
ADD target/inventory-management-docker.jar inventory-management-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/inventory-management-docker.jar"]
