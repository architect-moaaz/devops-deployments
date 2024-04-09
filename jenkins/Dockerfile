from jenkins/jenkins:latest

# Distributed Builds plugins
#RUN /usr/local/bin/install-plugins.sh ssh-slaves



# RUN jenkins-plugin-cli --plugins email-ext mailer slack htmlpublisher ssh-slaves job-dsl:1.81 pipeline-build-step:2.18 pipeline-rest-api:2.30 pipeline-stage-view:2.30 blueocean-rest:1.27.1 script-security pipeline-groovy-lib groovy github git:5.0.0  cloudbees-folder echarts-api docker-plugin docker-workflow credentials credentials-binding configuration-as-code commons-text-api docker-build-publish blueocean-core-js ace-editor:1.1 ant:1.5 antisamy-markup-formatter:1.5 authentication-tokens:1.3 blueocean-autofavorite:1.0.0 blueocean-commons:1.1.4 blueocean-config:1.1.4 blueocean-dashboard:1.1.4 blueocean-display-url:2.0 blueocean-events:1.1.4 blueocean-git-pipeline:1.1.4 blueocean-github-pipeline:1.1.4 blueocean-i18n:1.1.4 blueocean-jwt:1.1.4 blueocean-personalization:1.1.4 blueocean-pipeline-api-impl:1.1.4 blueocean-pipeline-editor:0.2.0 blueocean-pipeline-scm-api:1.1.4 blueocean-rest-impl:1.1.4


RUN jenkins-plugin-cli --plugins ace-editor ant antisamy-markup-formatter apache-httpcomponents-client-4-api authentication-tokens bouncycastle-api branch-api build-timeout cloudbees-folder command-launcher credentials credentials-binding display-url-api docker-commons docker-workflow durable-task email-ext git git-client git-server github github-api github-branch-source github-organization-folder gradle handlebars icon-shim jackson2-api jquery-detached jsch junit ldap mailer mapdb-api matrix-auth matrix-project momentjs pam-auth plain-credentials pipeline-build-step pipeline-github-lib pipeline-graph-analysis pipeline-input-step pipeline-milestone-step pipeline-model-api pipeline-model-declarative-agent pipeline-model-definition pipeline-model-extensions pipeline-rest-api pipeline-stage-step pipeline-stage-tags-metadata pipeline-stage-view resource-disposer scm-api script-security ssh-credentials ssh-slaves structs subversion timestamper token-macro workflow-aggregator workflow-api workflow-basic-steps workflow-cps workflow-cps-global-lib workflow-durable-task-step workflow-job workflow-multibranch workflow-scm-step workflow-step-api workflow-support ws-cleanup groovy


USER root
# install docker & maven
RUN apt-get update && apt-get -y install \
    maven \
    ca-certificates \
    curl \
    gnupg \
    lsb-release
# RUN curl -fsSLO https://get.docker.com/builds/Linux/x86_64/docker-17.04.0-ce.tgz \
#   && tar xzvf docker-17.04.0-ce.tgz \
#   && mv docker/docker /usr/local/bin \
#   && rm -r docker docker-17.04.0-ce.tgz

RUN curl -fsSL https://download.docker.com/linux/debian/gpg | gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
RUN echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null
RUN apt-get update && apt-get -y install docker-ce docker-ce-cli containerd.io

RUN usermod -aG docker jenkins


# install kubectl
RUN curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl; chmod +x ./kubectl; mv ./kubectl /usr/local/bin/kubectl


USER jenkins

