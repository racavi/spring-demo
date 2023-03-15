pipeline {
    agent {
        kubernetes {
            yaml '''
        apiVersion: v1
        kind: Pod
        spec:
          containers:
          - name: maven
            image: maven:alpine
            command:
            - cat
            tty: true
        '''
        }
    }
    stages {
        stage('Checkout Repository') {
            steps {
                sh 'pwd'
                checkout scmGit(branches: [[name: 'master']], extensions: [], userRemoteConfigs: [[credentialsId: '377453c5-fa64-4eed-be2c-95c8cdd70ad8', url: 'https://github.com/racavi/spring-demo.git']])
                sh 'pwd'
            }
        }
        stage('Build') {
            steps {
                container('maven') {
                    sh 'pwd'
                    sh 'cd app/'
                    sh 'mvn -version'
                    sh 'mvn clean install'
                }
            }
        }
    }
}
