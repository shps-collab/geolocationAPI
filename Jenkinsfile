node {
  //Checks out the git repo before running maven commands
  stage('Source Code Management (SCM)') {
    checkout scm
  }
  //Maven clean -> Remove files from the previous build
  stage ('Mvn Clean') {
    withMaven {
      sh "mvn clean"
    }
  }
  //Maven install -> Builds project, runs tests, and generates .war file based on the parameters in the pom.xml
  stage ('Mvn Install') {
    withMaven {
      sh "mvn install"    
    }
  }
  //Run SonarQube Analysis if Maven install was successful  
  //stage('SonarQube Analysis') {
  //  def mvn = tool 'seerleticsSbAdminPro';
  //  withSonarQubeEnv() {
  //    sh "${mvn}/bin/mvn sonar:sonar"
  //  }
  //}
  //Maven install -> Builds project, runs tests, and generates .war file based on the parameters in the pom.xml
  stage ('Docker Build') {    
    withMaven {
      sh "sudo docker build -t geolocationapi ."    
    }
  }
  //Maven install -> Builds project, runs tests, and generates .war file based on the parameters in the pom.xml
  stage ('Docker Run') {
    withMaven {
      sh "sudo docker run -p 5001:8080 geolocationapi ."    
    }
  }
}