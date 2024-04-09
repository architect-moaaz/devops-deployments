pipeline {
    agent {
      	docker {
        	image 'docker:latest'
            args '--privileged'       
            }
      }    
      parameters {
        string(name: 'branchName', defaultValue: 'master', description: 'Branch Name')
        string(name: 'repoUrl', defaultValue: 'git@github.com:waldemarnt/node-docker-example.git', description: 'Branch Name')
    }
  stages {

    stage('Clone repo') {



      steps {
                    //   git branch: branchName, credentialsId: gitCredentials, url: repoUrl
                    git branch: params.branchName,  url: params.repoUrl
    //         git branch: params.branchName, url: params.repoUrl
        }
        //   git branch: branchName, credentialsId: 	gitCredentials, url: repoUrl
    }

    stage('Build Stage') {
    // 	agent {
    //   	docker {
    //     	image 'docker:latest'
    //     }
    //   }
      steps {
      	sh 'docker build -t harsh/test:latest .'
      }
    }
   }

}
