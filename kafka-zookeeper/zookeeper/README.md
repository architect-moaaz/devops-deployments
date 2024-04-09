helm install -f Values.yaml -n control-plane zookeeper  bitnami/zookeeper   --set auth.enabled=false   --set allowAnonymousLogin=true




** Please be patient while the chart is being deployed **

ZooKeeper can be accessed via port 2181 on the following DNS name from within your cluster:

    zookeeper.control-plane.svc.cluster.local

To connect to your ZooKeeper server run the following commands:

    export POD_NAME=$(kubectl get pods --namespace control-plane -l "app.kubernetes.io/name=zookeeper,app.kubernetes.io/instance=zookeeper,app.kubernetes.io/component=zookeeper" -o jsonpath="{.items[0].metadata.name}")
    kubectl exec -it $POD_NAME -- zkCli.sh

To connect to your ZooKeeper server from outside the cluster execute the following commands:

    kubectl port-forward --namespace control-plane svc/zookeeper 2181:2181 &
    zkCli.sh 127.0.0.1:2181
