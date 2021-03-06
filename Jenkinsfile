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
                        sh 'chmod +x -R ${env.WORKSPACE}'
                        sh './fake-deploy.sh'
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}