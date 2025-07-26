// pipeline {
//     agent any
//      triggers {
//             cron('30 5 * * 1')
//             cron('0 14 * * *')
//         }
//
//
//     parameters {
//         string(name: 'REPO_URL', defaultValue: 'https://github.com/hila5135/clalitPharmacyAutomation.git', description: 'Repository URL')
//         string(name: 'NAME_BRANCH', defaultValue: 'main', description: 'Branch name to build')
//     }
//     environment {
//         MAIN_BRANCH = 'main'
//     }
//     stages {
//        stage('Checkout from MAIN branch'){
//                when {
//                   expression { return params.NAME_BRANCH == env.MAIN_BRANCH }
//                }
//           steps {
//           timeout(time: 5, unit: 'MINUTES'){
//                echo "Starting checking out with scm (main branch)"
//                checkout scm
//                echo "Ending checking out with scm (main branch)"
//
//               }
//             }
//           }
//
//
//        stage('Checkout from other branch '){
//
//          when {
//             expression { return params.NAME_BRANCH != env.MAIN_BRANCH }
//             }
//
//          steps{
//          timeout(time: 5, unit: 'MINUTES'){
//                    echo "Starting checking out with manual git"
//                    git branch: "${params.NAME_BRANCH}", url: "${params.REPO_URL}"
//                    echo "Ending checking out with manual git"
//          }
//          }
//         }
//         stage("Code compile") {
//             steps {
//                 timeout(time: 5, unit: 'MINUTES') {
//                     echo "Starting compilation stage"
//                     sh "mvn clean compile"
//                     echo "Ending compilation stage"
//                 }
//             }
//         }
//
//       stage("Running tests"){
//         steps{
//        timeout(time: 5, unit: 'MINUTES') {
//            echo "Starting running tests......"
//            sh "mvn test"
//            echo "Ending running tests......."
//          }
//         }
//       }
// }
//       post{
//        success{
//          echo "Pipeline completed successfully!"
//        }
//        failure{
//          echo "Pipeline failed!"
//        }
//       }
//
// }


pipeline {
    agent any

    triggers {
        cron('30 5 * * 1')
        
    }

    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/hila5135/clalitPharmacyAutomation.git', description: 'Repository URL')
        string(name: 'NAME_BRANCH', defaultValue: 'main', description: 'Branch name to build')
    }

    environment {
        MAIN_BRANCH = 'main'
    }

    stages {

        stage('Checkout from MAIN branch') {
            when {
                expression { return params.NAME_BRANCH == env.MAIN_BRANCH }
            }
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "Starting checking out with scm (main branch)"
                    checkout scm
                    echo "Ending checking out with scm (main branch)"
                }
            }
        }

        stage('Checkout from other branch') {
            when {
                expression { return params.NAME_BRANCH != env.MAIN_BRANCH }
            }
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "Starting checking out with manual git"
                    git branch: "${params.NAME_BRANCH}", url: "${params.REPO_URL}"
                    echo "Ending checking out with manual git"
                }
            }
        }

        stage('Code compile') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "Starting compilation stage"
                    sh "mvn clean compile"
                    echo "Ending compilation stage"
                }
            }
        }

        stage('Running tests') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "Starting running tests..."
                    sh "mvn test"
                    echo "Ending running tests..."
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
