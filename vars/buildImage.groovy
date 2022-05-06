#!/usr/bin/env groovy

def call() {
    echo "Building the application"
    withCredentials([usernamePassword(credentialsId:'hub-docker-repo',usernameVariable:'USER',passwordVariable:'PASS')]) {
        sh 'docker build -t doomedmonk13/test1:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push doomedmonk13/test1:jma-2.0'
    }
}
