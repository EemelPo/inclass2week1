pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "inclass2week1"
        DOCKER_TAG = "latest"
        DOCKER_HUB_REPO = "eemelpo/inclass2week1"
    }
    stages {
        stage('Build Docker Image') {
            steps {
                bat "docker build -t %DOCKER_IMAGE%:%DOCKER_TAG% ."
            }
        }
        stage('Deploy Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
                        bat "docker tag %DOCKER_IMAGE%:%DOCKER_TAG% %DOCKER_HUB_REPO%:%DOCKER_TAG%"
                        bat "docker push %DOCKER_HUB_REPO%:%DOCKER_TAG%"
                    }
                }
            }
        }
    }
}
