#!/usr/bin/env groovy

def call(String imageName) {
    echo "Building the application"
    withCredentials([usernamePassword(credentialsId:'hub-docker-repo',usernameVariable:'USER',passwordVariable:'PASS')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push $imageName"
    }
}
