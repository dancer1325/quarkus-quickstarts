Quarkus guide: https://quarkus.io/guides/microprofile-fault-tolerance

## Notes
* "quarkus-smallrye-fault-tolerance"
  * Quarkus implementation of [microprofile-fault-tolerance](https://microprofile.io/specifications/microprofile-fault-tolerance/)

## Sample requests
* Ways to launch the request
  * Open the browser to check more clear, how the requests fail
    * `http://localhost:8080/coffee` 
  * Via curl / http / ..
    * `curl localhost:8080/coffee -v`
    * `curl localhost:8080/coffee/2/recommendations -v`
* Once you launch the requests -> You can check in the logs, ERROR traces from time to time
* [Circuit Breaker](https://quarkus.io/guides/smallrye-fault-tolerance#adding-resiliency-circuit-breaker)
  * Hit 4 times `curl localhost:8080/coffee/2/availability -v`
    * 3th and 4th case will return "RuntimeException: Service failed."
  * If you hit another time, not 5 seconds later, you get "CircuitBreakerOpenException: getAvailability"