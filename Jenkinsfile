pipeline {
    agent {
        label {
            label "built-in"
            customWorkspace "/mnt/projects"
        }
    }

    environment {
        url = "https://github.com/Lucifer7669/game-of-life.git"
    }

    stages {
        stage ('clone project'){
            steps {
                sh "rm -rf *"
                sh "git clone $url"
            }
        }

        stage ('build-phase'){
            steps {
                sh "cd game-of-life && mvn clean install"
            }
        }

        stage ('copying-phase'){
            steps {
                sh "cp -r game-of-life/gameoflife-web/target/gameoflife.war /mnt/wars"
            }
        }
    }
}