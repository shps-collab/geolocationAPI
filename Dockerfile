FROM tomcat

COPY ROOT.war /usr/local/tomcat/webapps/

#FROM openjdk:11
EXPOSE 8080
ADD target/geolocationAPI.war geolocationAPI.war 
ENTRYPOINT ["java","-war","/geolocationAPI.war"]