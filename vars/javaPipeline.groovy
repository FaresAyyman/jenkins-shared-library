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

        stage("Build JAR") {
            dir('java') {
                sh 'mvn clean package install -Dmaven.test.skip=true'
            }
        }

        stage("Build & Push Docker Image") {
            dir('java') {
                docker.buildJavaImage()
                docker.pushJavaImage()
            }
        }
    }
}
