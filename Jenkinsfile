pipeline {
    agent {
        kubernetes {
            yaml '''
        apiVersion: v1
        kind: Pod
        spec:
          containers:
          - name: maven
            image: maven:3.9-eclipse-temurin-17-alpine
            command:
            - cat
            tty: true
        '''
        }
    }
    options {
        checkoutToSubdirectory('app')
    }
    stages {
//        stage('Checkout Repository') {
//            steps {
//                sh 'pwd'
//                sh 'ls -la'
//                checkout scmGit(branches: [[name: 'master']], extensions: [], userRemoteConfigs: [[credentialsId: '377453c5-fa64-4eed-be2c-95c8cdd70ad8', url: 'https://github.com/racavi/spring-demo.git']])
//                sh 'pwd'
//                sh 'ls -la'
//            }
//        }
        stage('Build') {
            steps {
                container('maven') {
                    dir('app') {
//                        sh 'pwd'
//                        sh 'ls -la'
//                        sh 'mvn -version'
                        sh 'mvn clean package'
                    }
                }
            }
        }
    }
}
