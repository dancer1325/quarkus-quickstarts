Quarkus guide: https://quarkus.io/guides/stork-kubernetes

## Notes
* `quarkus-smallrye-stork`
  * Offers
    * Service discovery mechanism
    * Built-in support for
      * Consul
      * Kubernetes
    * Customizable client load-balancing strategies
* Check the architecture of the application [here](https://quarkus.io/guides/stork-kubernetes#architecture)

The kubernetes folder contains two manifests corresponding to two simple applications, 
they are the instances of the service we will discover using Stork Kubernetes Service discovery.
These manifests can be applied to the cluster using kubectl:
```shell
kubectl create namespace development
kubectl apply -f kubernetes-setup.yml -n=development
kubectl apply -f target/kubernetes/kubernetes.yml -n=development
```
Go to my-service.127.0.0.1.nip.io/api
