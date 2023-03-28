pipeline {
    agent {
        label {
            label "Dev-Node"
            customWorkspace "/mnt/project"
        }
    }

    environment {
        url = "https://github.com/Lucifer7669/velocity-devops-project-docker-compose.git"
        composedir = "velocity-devops-project-docker-compose"
    }

    stages {
        stage ("clone-docker-compose-file"){
            steps {
                sh "sudo rm -rf *"
                sh "sudo yum install git -y"
                sh "sudo git clone ${url}"
            }
        }

        stage ("deployment-on-dev"){
            steps {
                sh "cd ${composedir} && sudo docker-compose up -d"
            }
        }
    }
}