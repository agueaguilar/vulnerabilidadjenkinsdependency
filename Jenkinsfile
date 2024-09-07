pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/agueaguilar/vulnerabilidadjenkinsdependency.git', branch: 'main'
            }
        }
        stage('Verify Python and Pandoc') {
            steps {
                bat 'python --version'
                bat 'pandoc --version'
            }
        }
        stage('Build') {
            steps {
                sh 'javac LoginApp.java'
            }
        }
        stage('Package') {
            steps {
                sh 'jar cvf LoginApp.jar LoginApp.class'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose up -d'
            }
        }
        stage('Vulnerability Scan') {
            steps {
                dependencyTrackPublisher artifact: 'LoginApp.jar'
            }
        }
        stage('Generate Report') {
            steps {
                sh 'pandoc scan-results.json -o report.pdf'
            }
        }
        stage('Send Report') {
            steps {
                mail to: 'aguedaaguilar14@gmail.com',
                     subject: "Reporte de Vulnerabilidades",
                     body: "Adjunto el reporte de vulnerabilidades en formato PDF.",
                     attachFiles: 'report.pdf'
            }
        }
    }
}
