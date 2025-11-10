# Getting started with Quarkus

* goal
  * CRUD service / expose endpointS -- over -- REST

* approach
  * RESTEasy
    * expose the REST endpoints
  * REST-assured & JUnit 5
    * -- for -- endpoint testing

## Requirements

- JDK 11+
- ⚠️GraalVM ⚠️
  - ways
    - -- via -- SDKMAN
      - `sdk install java 17.0.9-graal`

### Configuring GraalVM and JDK 11+

* [how to build a Native Executable guide](https://quarkus.io/guides/building-native-image-guide)

## how to build the application?

* `./mvnw package`
  * Problems:
    * Problem1: " The following artifacts could not be resolved: com.thoughtworks.qdox:qdox:jar:2.0-M9, org.codehaus.plexus:plexus-compiler-api:jar:2.8.4, org.codehaus.plexus:plexus-compiler-manager:jar:2.8.4, org.codehaus.plexus:plexus-compiler-javac:jar:2.8.4: Could not transfer artifact com.thoughtworks.qdox:qdox:jar:2.0-M9 from/to artifactory"
      * Solution: 
        * ❌NOT use GraalVM JDK 25❌
        * `source ~/.bashrc` & `java-local`

## how to run?
### live coding

* `./mvnw quarkus:dev`
  * allows
    * 👀code & running👀
      * test1
        * http://127.0.0.1:8080
        * changes [index.html](src/main/resources/META-INF/resources/index.html)
        * refresh the browser
          * check the change reflected
      * test2
        * http://127.0.0.1:8080/hello
        * [change endpoint's response](src/main/java/org/acme/getting/started/GreetingResource.java)
        * refresh the browser
          * check the change reflected
  * provided -- by -- Maven Quarkus plugin

### | JVM mode

* == -- as a -- conventional jar file
* steps
  * `./mvnw package`
    * `ls -lh target/quarkus-app/quarkus-run.jar` 
  * `java -jar ./target/quarkus-app/quarkus-run.jar`

### -- as a -- native executable

* steps
  * `./mvnw package -Dnative`
    * Problems:
      * Problem1: "[error]: Build step io.quarkus.deployment.pkg.steps.NativeImageBuildStep#build threw an exception: java.lang.RuntimeException: Failed to get GraalVM version"
        * Solution: 👀install GraalVM  
          * `sdk install java 17.0.9-graal`👀
    * `ls -lh target/getting-started-1.0.0-SNAPSHOT-runner`
      * 's size << [jar + JVM](#-jvm-mode)
  * `./target/getting-started-1.0.0-SNAPSHOT-runner`

## Quarkus REST resources vs Jakarta REST resources
### ❌NO need to create an `Application` class❌
* there is NO `Application` class | [src](src/main/java/org/acme)
### 1! resource instance
* [run it](#how-to-run)
* hit MULTIPLE [requests](sample.http)
* | application's running logs
  * ONLY find 1! GreetingResource instance created: #1
#### != 1 resource instance / request
* [up](#1-resource-instance)
  * ALTHOUGH you hit MULTIPLE requests -> ONLY 1! time logged
#### if you want to configure it -> use `*Scoped` annotations
* [GreetingService.java](src/main/java/org/acme/getting/started/GreetingService.java)

## Using injection
### ArC
#### inherit -- from -- `quarkus-rest`
* [pom.xml](pom.xml)
