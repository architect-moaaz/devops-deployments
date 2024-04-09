pipeline {
        // agent any
        agent {
          	docker {
            	image 'ishu0824/docker-build:latest'
                args '--privileged'  
                // reuseNode true
            }
        }
        environment {
        // The KUBECONFIG environment variable will be assigned
            KUBECONFIG = credentials('kubeconfig')
        }
        parameters {
            string(name: 'workspace', defaultValue: 'Intelliflow', description: 'Workspace Name')
            string(name: 'appName', defaultValue: 'chatroom', description: 'Mini App Name')
        }
        
         options {
         disableConcurrentBuilds()
        }
        
    
        stages {
            
            stage('Init'){
                // agent none
                // agent {
                //   	docker {
                //     	image 'docker:latest'
                //         args '--privileged'       
                //     }
                // }  
                steps{
                    sh "pwd"
                    sh "ls"
                    // sh "rm -rf *"
                    // sh "ls"
                    
                     
                    
               
                }
            }
            
            
            stage('GIT Checkout') {
                // agent none
                // agent {
                //   	docker {
                //     	image 'docker:latest'
                //         args '--privileged'  
                //         // reuseNode true
                //     }
                // }  
                steps {
  
                   
                   git url: '/if-repo/'+params.workspace+'/'+params.appName+'/.git'
                   echo "checkout"
                   
                   sh "cp -R /if-repo/"+params.workspace+"/"+params.appName+"/* ."
                   sh "ls"
                    // stash includes: '*', name: 'miniapp'
                    

                }
                
            }
            
            stage('Build') {
                // agent any
            // 	agent {
            //       	docker {
            //         	image 'maven:3.6.3-jdk-11'
            //         }
            //     }
                steps {
                    
                    echo "Generating Native Build for ${params.appName}"
                    sh """
                      ls 
                      mvn clean package -Dquarkus.container-image.build=true
                      ls target/kubernetes
                      cat target/kubernetes/minikube.yml
                      cat target/kubernetes/kubernetes.yml
                    """

                }
            }
                    
            stage('Deploy MiniApp') {
                environment {
                        NAMESPACE=params.workspace.toLowerCase()
                }
                steps {
                    
                    sh """
                      ls
                      #kubectl --kubeconfig $KUBECONFIG create ns ${NAMESPACE}
                      kubectl --kubeconfig $KUBECONFIG apply -f target/kubernetes/minikube.yml -n ${NAMESPACE}
                    """
                }
            }   


        }
    //     post { 
    //         // always { 
    //         //     deleteDir()
    //         // }
    // }
    }
