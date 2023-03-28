pipeline {
    agent {
        label {
            label "built-in"
            customWorkspace "/mnt/wars"
        }
    }

    environment {
        devIp = "10.10.10.27"
        qaIp = "10.10.20.177"
    }

    stages {
        stage ('copying-wars-to-dev'){
            steps {
                sh "sudo rm -rf *"
                sh "scp -r gameoflife.war devops@${devIp}:/mnt/wars"
            }
        }

        stage ('copying-wars-to-qa'){
            steps {
                sh "sudo rm -rf *"
                sh "scp -r gameoflife.war devops@${qaIp}:/mnt/wars"
            }
        }
    }
}