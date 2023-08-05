Quarkus guide: https://quarkus.io/guides/microprofile-health

## Notes
* "quarkus-smallrye-health"
  * Quarkus implementation of [microprofile-health](https://github.com/eclipse/microprofile-health)
    * Microprofile-health doesn't support reactive types
  * Support Async health checks
  * Comes with "health-ui"
    * Open in the browser "http://localhost:8080/q/health-ui/"
* `@Liveness`
  * Check if our application is running or not
* `@Readiness`
  * Check if our application is able to process requests
* 

## Sample requests
* Importing "quarkus-smallrye-health" -> some REST endpoints are exposed directly
  * `curl localhost:8080/q/health -v`
    * Display all the possible healths: live, ready and started
  * `curl localhost:8080/q/health/live -v`
    * Return all the health check procedures, declared with `@Liveness`
  * `curl localhost:8080/q/health/ready -v`
    * Return all the health check procedures, declared with `@Readiness`
  * `curl localhost:8080/q/health/started -v`
    * Return all the health check procedures, declared with `@Startup`