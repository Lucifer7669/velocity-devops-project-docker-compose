pipeline {
    agent {
        label {
            label "QA-Node"
            customWorkspace "/mnt/projects"
        }
    }

    environment {
        url = "https://github.com/Lucifer7669/velocity-devops-project-docker-compose.git"
        composedir = "velocity-devops-project-docker-compose"
    }

    stages {
        stage ('clone-compose-file'){
            steps {
                sh "sudo rm -rf *"
                sh "sudo yum install git -y"
                sh "sudo git clone ${url}"
            }
        }
        stage ('deployment-on-qa'){
            steps {
                sh "cd ${composedir} && sudo docker-compose up -d"
            }
        }

    }
}