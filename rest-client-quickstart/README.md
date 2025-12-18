Quarkus guide: https://quarkus.io/guides/rest-client-reactive

* goal
  * how to consume part [stage.code.quarkus.io](https://stage.code.quarkus.io)

# how has it been created?
* `quarkus create -P io.quarkus.platform:quarkus-bom:3.22.3 rest-client-quickstart --extension='rest-jackson,rest-client-jackson'`

# How to create a REST Client?
## == interface /
### has Jakarta REST and MicroProfile annotations
* [ExtensionsService.java](src/main/java/org/acme/rest/client/ExtensionsService.java)
### handle ALL networking and marshalling
* TODO:
## `@RegisterRestClient` informs Quarkus / this interface is available for CDI injection -- as a -- REST Client
* TODO:
## media types
### if you install `quarkus-rest-client-jackson` extension -> by default, `application/json`
* TODO:
### explicitly set -- via -- `@Produces` or `@Consumes` annotations
* TODO:
## types of calls
### sync
* ALL except to `CompletionStage<>` & `Uni<>`
### async
* `CompletionStage<>` & `Uni<>`

# Query Parameters
## ways to specify
### `@QueryParam` OR `@RestQuery` | client method parameter
* [ExtensionsResource.java](src/main/java/org/acme/rest/client/ExtensionsResource.java)
### `@ClientQueryParam` | REST client interface OR interface's method
* [ExtensionsResource.java](src/main/java/org/acme/rest/client/ExtensionsResource.java)
## if parameters are NOT known in advance -> specify as a `Map`
* TODO:
## if you want to send array values -> use `MultivaluedMap`
* TODO:

