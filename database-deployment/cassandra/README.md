
user cassandra
User : amdincolo
pass: Wei8air0Wei8air


cammand 

helm upgrade --install -n control-plane -f Values.yml cassandra bitnami/cassandra


connect 


To connect to your Cassandra cluster using CQL:

1. Run a Cassandra pod that you can use as a client:

   kubectl run --namespace control-plane cassandra-client --rm --tty -i --restart='Never' \
   --env CASSANDRA_PASSWORD=$CASSANDRA_PASSWORD \
    \
   --image docker.io/bitnami/cassandra:4.1.0-debian-11-r11 -- bash

2. Connect using the cqlsh client:

   cqlsh -u cassandra -p $CASSANDRA_PASSWORD cassandra

To connect to your database from outside the cluster execute the following commands:

   export NODE_IP=$(kubectl get nodes --namespace control-plane -o jsonpath="{.items[0].status.addresses[0].address}")
   export NODE_PORT=$(kubectl get --namespace control-plane -o jsonpath="{.spec.ports[0].nodePort}" services cassandra)

   cqlsh -u cassandra -p $CASSANDRA_PASSWORD $NODE_IP $NODE_PORT








   Issue resolves 

   https://github.com/rancher/rancher/issues/6139

   kubectl run --namespace control-plane cassandra-client5 --rm --tty -i --restart='Never'    --env CASSANDRA_PASSWORD=Wei8air0Wei8air --env CASSANDRA_USER=cassandra   --env CQLSH_HOST=cassandra.control-plane.svc.cluster.local --env CQLSH_PORT=9042  --image docker.io/bitnami/cassandra:4.1.0-debian-11-r11 -- bash\
   