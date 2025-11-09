Quarkus guide: https://quarkus.io/guides/microprofile-health

## how to run?
* `./mvnw quarkus:dev`

## Health UI
* | browser,
  * http://localhost:8080/q/health-ui/

## Notes
* `@Liveness`
  * Check if our application is running or not
* `@Readiness`
  * Check if our application is able to process requests
