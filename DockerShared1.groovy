package org.iti

def login(USERNAME, PASSWORD) {
    sh "docker login -u ${USERNAME} -p ${PASSWORD}"
}


def buildPythonImage() {
    sh "docker build -t faresayyman/python-app:latest ."
}

def pushPythonImage() {
    sh "docker push faresayyman/python-app:latest"
}


def buildJavaImage() {
    sh "docker build -t faresayyman/java-app:latest ."
}

def pushJavaImage() {
    sh "docker push faresayyman/java-app:latest"
}
