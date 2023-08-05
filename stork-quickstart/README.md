Quarkus guide: https://quarkus.io/guides/stork

## Notes
* Nowadays, you have multiple instances of your service to
  * share the load or
  * improve the resiliency by redundancy
* `quarkus-smallrye-stork`
    * offers
        * Service discovery mechanism
          * === select the best service's instance
        * Built-in support for
            * Consul
            * Kubernetes
        * Customizable client load-balancing strategies
* [Architecture](https://quarkus.io/guides/stork#architecture)
* `smallrye-mutiny-vertx-consul-client`
  * provides a Consul client to register our services in Consul
* `stork-service-discovery-consul`
  * provides an implementation of the service discovery for Consul

## How to run it? 
* Start the Consul instance via:
```shell
docker run \
    -d \
    -p 8500:8500 \
    -p 8600:8600/udp \
    consul agent -server -ui -node=server-1 -bootstrap-expect=1 -client=0.0.0.0
```
* `./mvnw install`
  * Package the application
* `java -jar target/quarkus-app/quarkus-run.jar`
  * Run the application
* Hit sample requests, to check how the workload is balanced
  * `curl http://localhost:8080/api`
  * `curl http://localhost:8080/api`
