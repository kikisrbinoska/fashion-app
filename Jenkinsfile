pipeline {
    agent {
        docker {
            image 'maven:3.8.6-openjdk-17'
            args '-v $HOME/.m2:/root/.m2'
       }
    }

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials-id')
        DOCKERHUB_REPO = 'kikisrbinoska/fashion'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Backend with Maven') {
            steps {
                dir('fashionApp') {
                    sh 'mvn clean package -DskipTests'
                }
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
                    docker.build("${env.DOCKERHUB_REPO}-frontend", "./fashion-fr")
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

