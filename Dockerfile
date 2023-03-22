FROM openjdk:11
EXPOSE 8080
ADD target/geolocationAPI.jar geolocationAPI.jar 
ENTRYPOINT ["java","-jar","/geolocationAPI.jar"]