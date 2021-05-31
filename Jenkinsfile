pipeline {
    agent { label 'master' }
    stages {
        stage('build') {
            steps {
                echo 'Building...'
                sh 'mvn --version'
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    echo "Like this second step"
                    echo "And a third step too!"
                '''
            }
        }
        stage('Chrome Tests') {
            steps {
                echo 'Testing Chrome...'
//                 sh 'echo "Chrome tests run here"'
//                 sh 'mvn test -DbrowserFamily=chrome'
            }
        }
        stage('Firefox Tests') {
            steps {
                echo 'Testing Firefox...'
//                 sh 'echo "Firefox tests run here"'
//                 sh 'mvn test -DbrowserFamily=firefox'
            }
        }
        stage('Opera Tests') {
            steps {
                echo 'Testing Opera...'
//                 sh 'echo "Opera tests run here"'
//                 sh 'mvn test -DbrowserFamily=opera'
            }
        }
        stage('Edge Tests') {
            steps {
                echo 'Testing Edge...'
//                 sh 'echo "Edge tests run here"'
//                 sh 'mvn test -DbrowserFamily=edge'
            }
        }
        stage('Sanity check') {
            steps {
                input "Proceed to deploy?"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
            archiveArtifacts '**/*.jar'
//             junit 'surefire-reports/*.xml'
        }
        success {
            echo 'This will run only if successful'

//             // Send report to Slack.
//             slackSend channel: '#ops-room',
//                 color: 'good',
//                 message: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
//
            // Send report to email.
            mail to: 'milos@wedoqa.co',
               subject: "Success on pipeline: ${currentBuild.fullDisplayName}",
               body: "All is well with ${env.BUILD_URL}"

    }
        failure {
            echo 'This will run only if failed'
            // Send report to email.
            mail to: 'milos@wedoqa.co',
               subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
               body: "Something is wrong with ${env.BUILD_URL}"
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
