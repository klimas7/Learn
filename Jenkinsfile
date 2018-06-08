pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'java8'
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true clean install'
            }
            post {
                success {
                    archive 'target/*.jar'
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}