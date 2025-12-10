Quarkus guide: https://quarkus.io/guides/micrometer

# Micrometer exposes metrics
## by default, | main HTTP server
* http://localhost:8080/q/metrics
  * exposed metrics
## customize to surface metrics | separate management port
* [here](#management-interface)

# 

# TODO:

# Management interface
* [application.properties](src/main/resources/application.properties)
## `quarkus.management.enabled=true`
* http://localhost:9000/q/metrics
## MORE OPTIONAL micrometer properties
* http://localhost:9000/q/metrics
  * ❌NOT valid❌
    * Reason:🧠TODO: 🧠
* http://localhost:9000/q/metrics/json
* http://localhost:9000/q/metrics/prometheus

# TODO:
