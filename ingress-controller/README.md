helm install -f ingress-values.yaml nginx-ingress ingress-nginx/ingress-nginx --set controller.publishService.enabled=true



## Colocation Setup 

```
helm install --namespace ingress-nginx -f colocation-values.yml nginx-ingress ingress-nginx/ingress-nginx --set controller.publishService.enabled=true
```