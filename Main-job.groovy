pipeline {
    agent any

    stages {
        stage ('shutdown-all-env'){
            steps {
                build 'shutdown-docker-compose'
            }
        }

        stage ('23Q1-complation'){
            steps {
                build '23Q1-complation'
            }
        }

        stage ('copy-wars'){
            steps {
                build 'copt-wars'
            }
        }

        stage ('dev-deployment'){
            steps {
                build 'dev-deployment'
            }
        }
        stage ('QA-deployment'){
            steps {
                build 'QA-deployment'
            }
        }
    }

}