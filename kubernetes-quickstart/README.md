# kubernetes-quickstart

## how has it been created?
* `quarkus create app -P io.quarkus.platform:quarkus-bom:3.22.3 org.acme:kubernetes-quickstart --extension='rest,kubernetes,jib'`
  * AUTOMATICALLY add

    ```xml, title=pom.xml
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-rest</artifactId>
    </dependency>
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-kubernetes</artifactId>
    </dependency>
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-container-image-jib</artifactId>
    </dependency>
    ```

    ```gradle
    implementation("io.quarkus:quarkus-rest")
    implementation("io.quarkus:quarkus-kubernetes")
    implementation("io.quarkus:quarkus-container-image-jib")
    ```

## generated Kubernetes resources
### -- thanks to -- dekorate
* [quarkus-kubernetes extension use it internally](https://github.com/search?q=repo%3Aquarkusio%2Fquarkus+dekorate+path%3A%2F%5Eextensions%5C%2Fkubernetes%5C%2F%2F&type=code)
### support
#### [vanilla](https://github.com/quarkusio/quarkus/tree/main/extensions/kubernetes/vanilla)
#### [openshift](https://github.com/quarkusio/quarkus/tree/main/extensions/kubernetes/openshift)
#### [minikube](https://github.com/quarkusio/quarkus/tree/main/extensions/kubernetes/minikube)
#### [kind](https://github.com/quarkusio/quarkus/tree/main/extensions/kubernetes/kind)

## how to package + run the application?
### way1
* `./mvnw package`
  * generates
    * | "target/quarkus-app/",
      * `quarkus-run.jar`
    * "target/quarkus-app/lib/"
      * copy the dependencies
* `java -jar target/quarkus-app/quarkus-run.jar` 

### way2
* `./mvnw package -Dquarkus.package.jar.type=uber-jar`
* `java -jar target/*-runner.jar`

## | package
### generate Kubernetes manifests
* [package](#how-to-package--run-the-application)
* check "target/kubernetes"
### build a container image -- via -- Jib
#### by default, disabled
* [package](#how-to-package--run-the-application)
* `docker images | grep kubernetes`
  * NOTHING returned
#### ways to build
##### `./mvnw package -Dquarkus.container-image.build=true`
* `docker images | grep kubernetes`
  * check it's generated
##### | "application.properties", quarkus.container-image.build=true
* `./mvnw package`
* `docker images | grep kubernetes`
  * check it's generated

## ways to apply | cluster
* [install kubectl](https://kubernetes.io/docs/tasks/tools/)
* `kubectl apply -f target/kubernetes/kubernetes.json` OR `kubectl apply -f target/kubernetes/kubernetes.yml`
  * Problems:
    * Problem1: "kubectl logs pod/kubernetes-quickstart-6c8c6b56bf-r2fxw
      Error from server (BadRequest): container "kubernetes-quickstart" in pod "kubernetes-quickstart-6c8c6b56bf-r2fxw" is waiting to start: trying and failing to pull image
      "
      * Solution: | "application.properties", `quarkus.kubernetes.image-pull-policy=Never`
  * `kubectl get all`
    * check pods & services are running

## customize the generated image
* check [application.properties](src/main/resources/application.properties)

## Generating idempotent resources
* TODO:

