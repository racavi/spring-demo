pipeline {
    agent {
        kubernetes {
            yaml '''
        apiVersion: v1
        kind: Pod
        spec:
          volumes:
          - name: local-maven-repo
            persistentVolumeClaim:
              claimName: maven-repo-pvc
          containers:
          - name: maven
            image: maven:3.9-eclipse-temurin-17-alpine
            command:
            - cat
            tty: true
            volumeMounts:
              - mountPath: "/root/.m2/repository"
                name: local-maven-repo
                readOnly: false
        '''
        }
    }
    options {
        checkoutToSubdirectory('app')
    }
    stages {
        stage('Checkout Repository') {
            steps {
                checkout scmGit(branches: [[name: 'master']], extensions: [], userRemoteConfigs: [[credentialsId: '377453c5-fa64-4eed-be2c-95c8cdd70ad8', url: 'https://github.com/racavi/spring-demo.git']])
            }
        }
        stage('Build') {
            steps {
                container('maven') {
                    dir('app') {
                        sh 'mvn -version'
                        sh 'mvn clean install'
                    }
                }
            }
        }
    }
}
