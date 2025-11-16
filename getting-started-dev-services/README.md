# Getting started with Quarkus

This is a minimal CRUD service exposing a couple of endpoints over REST.

Under the hood, this demo uses:

- RESTEasy to expose the REST endpoints
- REST-assured and JUnit 5 for endpoint testing
- Panache and Hibernate for persistence 
- Dev services 

## how has it been created?
* 
   ```shell
   mvn io.quarkus.platform:quarkus-maven-plugin:3.21.1:create \
       -DprojectGroupId=org.acme \
       -DprojectArtifactId=getting-started-dev-services \
       -Dextensions='rest'
   ```
* modify [GreetingResource.java](src/main/java/org/acme/GreetingResource.java) /
  * use `org.jboss.resteasy.reactive.RestQuery` annotation
* `./mvnw quarkus:add-extension -Dextensions='hibernate-orm-panache,jdbc-postgresql'`
  * add the persistence libraries
* create [Greeting](src/main/java/org/acme/Greeting.java)

## Requirements

To compile and run this demo you will need:

- JDK 17+
- A container runtime, such as Docker or Podman

### Configuring JDK 17+

Make sure that the `JAVA_HOME` environment variables have
been set, and that a JDK 17+ `java` command is on the path.

### Live coding with Quarkus

* `./mvnw quarkus:dev`
  * Problems:
    * Problem1: "[error]: Build step io.quarkus.datasource.deployment.devservices.DevServicesDatasourceProcessor#launchDatabases threw an exception: java.lang.RuntimeException: java.lang.IllegalStateException: Previous attempts to find a Docker environment failed. "
      * Solution: TODO:
### Run Quarkus in JVM mode

When you're done iterating in developer mode, you can run the application as a
conventional jar file.

First compile it:

> ./mvnw package

Then run it:

> java -jar ./target/quarkus-app/quarkus-run.jar

Have a look at how fast it boots, or measure the total native memory consumption.

