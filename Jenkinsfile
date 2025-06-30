pipeline {
    agent none

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials-id')
        DOCKERHUB_REPO = 'kikisrbinoska/fashion'
    }

    stages {
        stage('Checkout') {
            agent any
            steps {
                checkout scm
            }
        }

        stage('Build Backend with Maven') {
            agent {
                docker {
                    image 'maven:3.9.4-eclipse-temurin-17'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                dir('fashionApp') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Backend Image') {
            agent any
            steps {
                script {
                    docker.build("${env.DOCKERHUB_REPO}-backend", "./fashionApp")
                }
            }
        }

        stage('Build Frontend Image') {
            agent any
            steps {
                script {
                    docker.build("${env.DOCKERHUB_REPO}-frontend", "./fashion-frontend")
                }
            }
        }

        stage('Deploy to Kubernetes') {
            agent any
            steps {
                withCredentials([kubeconfigFile(credentialsId: 'kubeconfig-id', variable: 'KUBECONFIG')]) {
                    sh '''
                        docker run --rm -v $KUBECONFIG:/kubeconfig \
                        -v $(pwd)/k8s:/k8s \
                        bitnami/kubectl:latest \
                        --kubeconfig=/kubeconfig apply -f /k8s -n fashion-app
                    '''
                }
            }
        }
    }
}

