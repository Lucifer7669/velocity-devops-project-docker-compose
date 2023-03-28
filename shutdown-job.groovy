pipeline{
    agent {
        label {
            label "Dev-Node"
            customWorkspace "/mnt/project"
        }
    }

    environment {
        composedir = "velocity-devops-project-docker-compose"
    }

    stages {
        stage ("shutdown-dev-env"){
            steps {
                sh "cd ${composedir} && sudo docker-compose down"
                sh "sudo docker system prune -a -f"
            }
        }

        stage ("shutdown-qa-env"){
            agent {
                label {
                    label "QA-Node"
                    customWorkspace "/mnt/projects"
                }
            }

            steps {
                sh "cd ${composedir} && sudo docker-compose down"
                sh "sudo docker system prune -a -f"
            }
        }
    }
}