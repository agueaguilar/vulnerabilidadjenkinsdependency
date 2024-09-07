pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/agueaguilar/vulnerabilidadjenkinsdependency.git', branch: 'main'
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
        stage('Dependency Check') {
            steps {
                dependencyCheckPublisher pattern: '**/*.jar', 
                                        odcInstallation: 'Dependency-Check'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose up -d'
            }
        }
        stage('Generate Report') {
            steps {
                sh 'pandoc scan-results.json -o report.pdf'
            }
        }
        stage('Send Report') {
            steps {
                mail to: 'tu-correo@dominio.com',
                     subject: "Reporte de Vulnerabilidades",
                     body: "Adjunto el reporte de vulnerabilidades en formato PDF.",
                     attachments: 'report.pdf'
            }
        }
    }
}
