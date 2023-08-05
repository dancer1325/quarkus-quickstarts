Quarkus guide: https://quarkus.io/guides/microprofile-metrics

## Notes
* "quarkus-smallrye-metrics"
    * Quarkus implementation of [microprofile-health](https://github.com/eclipse/microprofile-metrics)
    * Gather metrics & statistics about what's happening inside the application
      * can be read and processed by tools such as Prometheus
## Sample requests
* `curl localhost:8080/350`
* `curl localhost:8080/629521085409773`
* `curl -H "Accept: application/json" localhost:8080/q/metrics/application`
  * Check the generated metrics
  * `@Timed`
    * `p` are percentiles
    * `stddev` is the standard deviation
* `curl localhost:8080/q/metrics/application`
  * If you don't specify the format accepted -> they are displayed as exported