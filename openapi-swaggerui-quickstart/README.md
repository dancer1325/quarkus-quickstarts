Quarkus guide: https://quarkus.io/guides/openapi-swaggerui

# Goal
* Expose Quarkus application's API through an OpenAPI specification
* Test Quarkus application via Swagger UI

# Sample requests
* `curl localhost:8080/fruits`
* `curl -d '{"name":"Irene", "description":"curvy"}' -H "Content-Type: application/json" -X POST localhost:8080/fruits -v`
* `curl -d '{"name":"Irene", "description":"AAAA"}' -H "Content-Type: application/json" -X DELETE localhost:8080/fruits -v`
* `curl localhost:8080/q/openapi -v`
  * Default OpenAPI endpoint
  * `curl "localhost:8080/q/openapi?format=json"`
    * Format to JSON format the response

# Notes
* Ways to provide application level OpenAPI annotations, via
  * microprofile-open-api
  * quarkus-smallrye-openapi  
* `quarkus-smallrye-openapi`
  * Implementation of [microprofile-open-api](https://github.com/eclipse/microprofile-open-api/) for [OpenAPI-v3](https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.0.md)
* Load OpenAPI schema from static fields
  * Create "META-INF/openapi.yaml", following [OpenAPI specification](https://swagger.io/docs/specification/about/)
    * 👀 Live reloaded is supported 👀
    * Alternative paths
      * "META-INF/openapi.yml"
      * "META-INF/openapi.json"
      * "WEB-INF/classes/META-INF/openapi.yml"
      * "WEB-INF/classes/META-INF/openapi.yaml"
      * "WEB-INF/classes/META-INF/openapi.json"
  * `curl "localhost:8080/q/openapi?format=json"`
    * :warning: OpenAPI document from static file + model generated from application endpoints code :warning:
  * | browser,
    * http://localhost:8080/q/openapi
* [Swagger UI](https://swagger.io/tools/swagger-ui/)
  * Included in `quarkus-smallrye-openapi`
  * | browser,
    * "http://localhost:8080/q/swagger-ui/"
