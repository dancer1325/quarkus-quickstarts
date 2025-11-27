# Quarkus quickstart example for OpenTelemetry

* == simple Quarkus application / 
  * instrumented with OpenTelemetry
  * telemetry data is seen | local Grafana LGTM DevService instance

* guides / EACH signal
  * [Tracing](https://quarkus.io/guides/opentelemetry-tracing)
  * [Metrics](https://quarkus.io/guides/opentelemetry-metrics)
  * [Logs](https://quarkus.io/guides/opentelemetry-logging)

## how has it been created?
### Tracing
* [TracedResource.java](src/main/java/org/acme/opentelemetry/TracedResource.java)
  * ❌NO require changes | code❌
### TODO:

## how to run it locally?
### -- via -- dev
* `./mvnw quarkus:dev`
  * Problems:
    * Problem1: "Caused by: java.lang.IllegalStateException: Previous attempts to find a Docker environment failed. Will not retry. Please see logs and check configuration"
      * Attempt1: `docker compose up -d`
      * Solution: TODO:
* TODO: 


## See telemetry

* Grafana LGTM DevService
  * provided -- by the -- `quarkus-observability-devservices-lgtm` dependency
  *  [guide](https://quarkus.io/guides/observability-devservices-lgtm)
