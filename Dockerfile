FROM openjdk:11
COPY target/geolocationAPI.war /usr/local/tomcat/webapps/
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/tomcat/webapps/geolocationAPI.war"]
