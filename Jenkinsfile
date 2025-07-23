pipeline {
    agent any
    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/hila5135/clalitPharmacyAutomation.git', description: 'Repository URL')
        string(name: 'NAME_BRANCH', defaultValue: 'main', description: 'Branch name to build')
    }
    environment {
        MAIN_BRANCH = 'main'
    }
    stages {
       stage('Checkot from MAIN branch'){
       timeout(time: 5, unit: 'MINUTES') {
          steps{
               when {
                  expression { return params.NAME_BRANCH == env.MAIN_BRANCH }
               }
          steps {
               echo "Starting checking out with scm (main branch)"
               checkout scm
               echo "Ending checking out with scm (main branch)"


               }
          }
          }
       }


       stage('Checkout from other branch '){
       timeout(time: 5, unit: 'MINUTES') {
        steps{
         when {
            expression { return params.NAME_BRANCH != env.MAIN_BRANCH }
            }
         }
         steps{
                   echo "Starting checking out with manual git"
                   git branch: "${parameters.NAME_BRANCH}", url: "${parameters.REPO_URL}"
                   echo "Ending checking out with manual git"
         }
        }
       }

      stage("Code compile"){
      timeout(time: 5, unit: 'MINUTES') {
          steps{
             echo "Starting compilation stage"
             sh "nvm clean compile"
             echo "Ending compilation stage"
          }
        }
      }

      stage("Running tests"){
       timeout(time: 5, unit: 'MINUTES') {
         steps{
           echo "Starting running tests......"
           sh "nvm test"
           echo "Ending running tests......."
         }
        }
      }

      post{
       success{
       echo "Pipeline completed successfully!"
       }
       failure{
       echo "Pipeline failed!"
       }
      }





    }
}
