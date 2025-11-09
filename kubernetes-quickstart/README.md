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

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application
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

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/kubernetes-quickstart-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Kubernetes ([guide](https://quarkus.io/guides/kubernetes)): Generate Kubernetes resources from annotations

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
