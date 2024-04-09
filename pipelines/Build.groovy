pipeline {
    agent {
      	docker {
        	image 'docker:latest'
            args '--privileged'       
            }
      }    
      parameters {
        string(name: 'branchName', defaultValue: 'main', description: 'Branch Name')
        string(name: 'imageName', defaultValue: 'intelliflow/ifs-modeller-svc', description: 'Image Name')
        string(name: 'repoUrl', defaultValue: 'git@gitlab.intelliflow.in:intelliflow/ifs-modeller-svc.git', description: 'Repo Name')
        string(name: 'Dockerfile_Path', defaultValue: '', description: 'Repo Name')
    }
  stages {

    stage('Clone repo') {



      steps {
                    //   git branch: branchName, credentialsId: gitCredentials, url: repoUrl
                    // git branch: params.branchName,  url: params.repoUrl
    //         git branch: params.branchName, url: params.repoUrl
            // git credentialsId: 'gitCredentials', url: params.repoUrl
            git branch: params.branchName,  credentialsId: 'gitCredentials', url: params.repoUrl
            // git branch: '${}', credentialsId: 'gitCredentials', url: 'git@gitlab.intelliflow.in:intelliflow/ifs-modeller-svc.git'
        }
          
    }

    stage('Build Stage') {
    // 	agent {
    //   	docker {
    //     	image 'docker:latest'
    //     }
    //   }
      steps {
          
        script {
            if ( params.Dockerfile_Path == null || params.Dockerfile_Path == "" ){
                sh "docker build -t ${params.imageName}:latest ."
            }else{
                sh "docker build -f ${params.Dockerfile_Path} -t ${params.imageName}:latest ."
            }
        }

    //   	sh "docker build -t ${params.imageName}:latest ."
      }
    }
   }

}
