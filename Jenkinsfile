pipeline {
    agent { label 'master' }
    stages {
        stage('Chrome Tests') {
            steps {
                sh 'echo "Chrome tests run here"'
//                 sh 'mvn test -DbrowserFamily=chrome'
            }
        }
        stage('Firefox Tests') {
            steps {
                sh 'echo "Firefox tests run here"'
//                 sh 'mvn test -DbrowserFamily=firefox'
            }
        }
        stage('Opera Tests') {
            steps {
                sh 'echo "Opera tests run here"'
//                 sh 'mvn test -DbrowserFamily=opera'
            }
        }
        stage('Edge Tests') {
            steps {
                sh 'echo "Edge tests run here"'
//                 sh 'mvn test -DbrowserFamily=edge'
            }
        }
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    echo "Like this second step"
                    echo "And a third step too!"
                '''
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
