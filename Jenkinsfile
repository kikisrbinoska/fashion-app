pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials-id') 
        DOCKERHUB_REPO = 'pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials-id'      
      DOCKERHUB_REPO = 'kikis/fashion'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Backend Image') {
            steps {
                script {
                    docker.build("${env.DOCKERHUB_REPO}-backend", "./fashionApp")
                }
            }
        }
        stage('Build Frontend Image') {
            steps {
                script {
                    docker.build("${env.DOCKERHUB_REPO}-frontend", "./fashion-frontend")
                }
            }
        }
        stage('Push Images') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credentials-id') {
                        docker.image("${env.DOCKERHUB_REPO}-backend").push('latest')
                        docker.image("${env.DOCKERHUB_REPO}-frontend").push('latest')
                    }
                }
            }
        }
    }
}
