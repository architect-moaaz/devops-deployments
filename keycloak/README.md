bitnami/keycloak

helm upgrade --install -n control-plane -f Values.yaml keycloak bitnami/keycloak

** Please be patient while the chart is being deployed **

Keycloak can be accessed through the following DNS name from within your cluster:

    keycloak.control-plane.svc.cluster.local (port 80)

To access Keycloak from outside the cluster execute the following commands:

1. Get the Keycloak URL by running these commands:

    export HTTP_NODE_PORT=$(kubectl get --namespace control-plane -o jsonpath="{.spec.ports[?(@.name=='http')].nodePort}" services keycloak)
    export HTTPS_NODE_PORT=$(kubectl get --namespace control-plane -o jsonpath="{.spec.ports[?(@.name=='https')].nodePort}" services keycloak)
    export NODE_IP=$(kubectl get nodes --namespace control-plane -o jsonpath="{.items[0].status.addresses[0].address}")

    echo "http://${NODE_IP}:${HTTP_NODE_PORT}/"
    echo "https://${NODE_IP}:${HTTPS_NODE_PORT}/"

2. Access Keycloak using the obtained URL.
3. Access the Administration Console using the following credentials:

  echo Username: admin
  echo Password: $(kubectl get secret --namespace control-plane keycloak -o jsonpath="{.data.admin-password}" | base64 -d)