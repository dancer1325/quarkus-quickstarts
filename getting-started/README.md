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
- GraalVM

### Configuring GraalVM and JDK 11+

* [how to build a Native Executable guide](https://quarkus.io/guides/building-native-image-guide)

## how to build the application?

> ./mvnw package

### Live coding with Quarkus

> ./mvnw quarkus:dev

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

### Run Quarkus in JVM mode

* TODO: 
When you're done iterating in developer mode, you can run the application as a
conventional jar file.

First compile it:

> ./mvnw package

Then run it:

> java -jar ./target/quarkus-app/quarkus-run.jar

Have a look at how fast it boots, or measure the total native memory consumption.

### Run Quarkus as a native executable

You can also create a native executable from this application without making any
source code changes. A native executable removes the dependency on the JVM:
everything needed to run the application on the target platform is included in
the executable, allowing the application to run with minimal resource overhead.

Compiling a native executable takes a bit longer, as GraalVM performs additional
steps to remove unnecessary codepaths. Use the  `native` profile to compile a
native executable:

> ./mvnw package -Dnative

After getting a cup of coffee, you'll be able to run this executable directly:

> ./target/getting-started-1.0.0-SNAPSHOT-runner
