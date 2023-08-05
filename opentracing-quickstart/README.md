Quarkus guide: https://quarkus.io/guides/opentracing

## Notes
* `quarkus-smallrye-opentracing`
  * Quarkus implementation of [microprofile-opentracing](https://github.com/eclipse/microprofile-opentracing/)
  * Provide distributed tracing for interactive web applications, including
    * OpenTracing support
      * Other technologies can be traced
        * [JDBC](https://quarkus.io/guides/opentracing#jdbc)
        * [Kafka](https://quarkus.io/guides/opentracing#kafka)
        * [MongoDB client](https://quarkus.io/guides/opentracing#mongodb-client)
        * [Zipkin](https://quarkus.io/guides/opentracing#zipkin-compatibility-mode)
    * [Jaeger](https://www.jaegertracing.io/) support
      * Way to configure it
        * via application.properties
        * via environment variables -- `/mvnw quarkus:dev -Djvm.args="-DJAEGER_SERVICE_NAME=myservice -DJAEGER_SAMPLER_TYPE=const -DJAEGER_SAMPLER_PARAM=1"` --
      * Open in the browser, the port exported for the UI "http://localhost:16686/search"
## Sample requests
* `docker run -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 jaegertracing/all-in-one:latest`
  * Run [jaeger image](https://hub.docker.com/r/jaegertracing/all-in-one)
* `curl localhost:8080/hello`
  * You can check the tracing via Jaeger UI -- "http://localhost:16686/search" --
* `curl localhost:8080/chain`
  * You can check the tracing via Jaeger UI -- "http://localhost:16686/search" --