pipeline {
    agent { docker { image 'maven:3.6.3' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }

        stage('Announce') {
            steps {
                sh '''
                   echo "Multiline shell steps works too"
                   ls -lah
                '''
            }
        }

        stage('Deploy') {
            steps {
                timeout(time: 3, unit: 'MINUTES') {
                    retry(5) {
                        sh './flakey-deploy.sh'
                    }
                }
            }
        }
    }
}