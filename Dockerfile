#FROM tomcat
FROM openjdk:11
COPY target/geolocationAPI.war /usr/local/tomcat/webapps/
COPY target/geolocationAPI/WEB-INF/classes/databases/GeoLite2-City.mmdb /usr/local/tomcat/webapps/WEB-INF/classes/databases/


EXPOSE 8080
#ADD target/geolocationAPI.jar geolocationAPI.jar 
ENTRYPOINT ["java","-jar","/usr/local/tomcat/webapps/geolocationAPI.war"]