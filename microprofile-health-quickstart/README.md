Quarkus guide: https://quarkus.io/guides/microprofile-health

## how has it been created?
* `quarkus create app -P io.quarkus.platform:quarkus-bom:3.22.3 org.acme:microprofile-health-quickstart --extension='rest,smallrye-health'`

## how to run?
* `./mvnw quarkus:dev`

## DIRECTLY exposes REST endpoint
* hit [sample.http](sample.http)
  * check EACH response's structure

## Creating your first health check
* [SimpleHealthCheck.java](src/main/java/org/acme/microprofile/health/SimpleHealthCheck.java)
  * hit "q/health/live" -> returned as response `.checks`

## Adding a readiness health check procedure
* [DatabaseConnectionHealthCheck.java](src/main/java/org/acme/microprofile/health/DatabaseConnectionHealthCheck.java)
  * hit "q/health/ready" -> returned as response `.checks`

## Adding a startup health check procedure
* [StartupHealthCheck.java](src/main/java/org/acme/microprofile/health/StartupHealthCheck.java)
  * hit "q/health/started" -> returned as response `.checks`

## Health UI
### | dev mode
* `./mvnw quarkus:dev`
* | browser,
  * http://localhost:8080/q/health-ui/
    * see ALL health checks
### | production mode
* TODO:
* | browser,
  * http://localhost:8080/q/health-ui/
    * see ALL health checks
