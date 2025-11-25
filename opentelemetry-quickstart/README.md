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
### 

## See telemetry

* Grafana LGTM DevService
  * provided -- by the -- `quarkus-observability-devservices-lgtm` dependency
  *  [guide](https://quarkus.io/guides/observability-devservices-lgtm)
