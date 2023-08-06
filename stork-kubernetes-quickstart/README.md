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
* `quarkus-kubernetes`
  * each time a new package is done -> generate a Kubernetes manifest
* `kubernetes-setup.yml` 
  * Kubernetes file which contains two manifests corresponding to two simple applications. 
  They are the instances of the service we will discover using Stork Kubernetes Service discovery.

## How to run it?
* Start up your cluster engine
* Run
```shell
kubectl create namespace development
kubectl apply -f kubernetes-setup.yml -n=development
```
  * Problems:
    * Problem1: "Unable to connect to the server: dial tcp 10.211.55.9:16443: i/o timeout"
      * Solution: `kubectl config view` and switch to the current-context which it's running `kubectl config use-context ClusterNameRunning`
* Go to my-service.127.0.0.1.nip.io/api
  * Problems:
    * Problem1: NO result is got
* `./mvnw package -Dquarkus.container-image.build=true -Dquarkus.container-image.push=true`
  * Generate a Kubernetes manifest in "target/kubernetes/" directory
  * Build and push a container image for the project in "quay.io/repository/"
  * Problems:
    * Problem1: "Failed to inject extension deployment dependencies ...kubernetes-model-core"
      * Solution: `rm -rf .m2/repository/io`
    * Problem2: JibProcessor "The credential helper (docker-credential-desktop) has nothing for server URL: quay.io"
      * Solution: Create a quay.io account, `docker login quay.io`
* `kubectl apply -f target/kubernetes/kubernetes.yml -n=development`
  * Problems:
    * Problem1: "pod/stork-kubernetes-quickstart" not ready, ImagePullBackOff status -> Not reachable 
      * Attempt1: `quarkus.container-image.registry=quay.io/dancer13/stork-kubernetes-quickstart` 
* Sample requests
  * Via browser
    *  http://my-service.127.0.0.1.nip.io/api
  * Via curl
    * `curl http://my-service.127.0.0.1.nip.io/api`
