package org.iti

class DockerShared1 {
    def steps

    DockerShared1(steps) {
        this.steps = steps
    }

    def login(username, password) {
        steps.sh "docker login -u ${username} -p ${password}"
    }

    def buildPythonImage() {
        steps.sh "docker build -t faresayyman/python-app:latest ."
    }

    def pushPythonImage() {
        steps.sh "docker push faresayyman/python-app:latest"
    }

    def buildJavaImage() {
        steps.sh "docker build -t faresayyman/java-app:latest ."
    }

    def pushJavaImage() {
        steps.sh "docker push faresayyman/java-app:latest"
    }
}
