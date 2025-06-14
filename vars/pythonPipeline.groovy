def call() {
    def docker = new org.iti.DockerShared1(this)

    node('Agent1') {
        withCredentials([usernamePassword(
            credentialsId: 'docker-hub-creds',
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWD'
        )]) {
            stage("Login Docker Hub") {
                docker.login(USERNAME, PASSWD)
            }
        }

        stage("Build Docker Image") {
            docker.buildPythonImage()
        }

        stage("Push Docker Image") {
            docker.pushPythonImage()
        }
    }
}
