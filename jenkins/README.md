docker run --name myjenkins -p 8080:8080 -p 50000:50000 -v 
/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock 
jenkins



docker build -t intelliflow/jenkins:1v .


docker run -d  --name colo-jenkins  -v /home/ifserveradmn/if-studio/if-repo:/if-repo:ro -v /home/ifserveradmn/if-studio/jenkins/home:/.jenkins  -v /var/run/docker.sock:/var/run/docker.sock  -p 38080:8080  -p 50000:50000 intelliflow/jenkins:1v



docker run -d -u 0  --name colo-jenkins  --env JAVA_OPTS="-Dhudson.plugins.git.GitSCM.ALLOW_LOCAL_CHECKOUT=true" -v /home/ifserveradmn/if-studio/if-repo:/if-repo:ro -v /home/ifserveradmn/if-studio/jenkins/home:/var/jenkins_home:rw  -v /var/run/docker.sock:/var/run/docker.sock:ro  -p 38080:8080  -p 50000:50000 intelliflow/jenkins:1v


Firewall

 sudo firewall-cmd --zone=public --add-port=38080/tcp


Permission
sudo chmod 766 /var/run/docker.sock 
sudo chmod 766 /var/run/docker.sock 