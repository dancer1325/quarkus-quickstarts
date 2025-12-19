Quarkus Kafka Quickstart
========================

* goal
  * Quarkus applications can interact -- , via MicroProfile Reactive Messaging, -- with Apache Kafka 

## Anatomy

#### [Producer application](producer)

* receive requests -- , via HTTP, -- from the user
* sends _quote requests_ -- to the -- Kafka broker

* Quote producer
  * POST "/quotes/request"
    * generates uniquely identified quote requests
    * sends quote requests -- to the -- Kafka topic `quote-requests`
  * GET "/quotes"
    * consumes the Kafka topic `quotes`
* ["quotes.html"](producer/src/main/resources/META-INF/resources/quotes.html)
  * HTML / 
    * enable button -- to -- sends quote requests
    * display quotes

#### Processor

The _processor_ application receives quote requests from Kafka, processes them, and writes results into the `quotes` Kafka topic.
The application has one main class:

* `QuoteProcessor` consumes quote request ids from the `quote-requests` Kafka topic and responds back to the `quotes` topic with a `Quote` object containing a random price.

The connection to Kafka is configured in the `src/main/resources/application.properties` file.

## ways to run
### | Dev mode

* | this path,
  * `mvn -f producer quarkus:dev`
  * `mvn -f processor quarkus:dev`

* Quarkus Dev Services
  * starts AUTOMATICALLY a Kafka broker

### | Docker

To run the application in Docker, first make sure that both services are built:

```bash
mvn package
```

Then launch Docker Compose:

```bash
docker-compose up
```

This will create a single-node Kafka cluster and launch both applications.

### | native

You can compile the application into a native binary using:

```bash
mvn package -Dnative
```

As you are running in _prod_ mode, you need a Kafka cluster.

If you have Docker installed, you can simply run:

```bash
export QUARKUS_MODE=native
docker-compose up --build
```

Alternatively, you can follow the instructions from the [Apache Kafka web site](https://kafka.apache.org/quickstart).

Then run both applications respectively with:

```bash
./producer/target/kafka-quickstart-producer-1.0.0-SNAPSHOT-runner
```

and in another terminal:

```bash
./processor/target/kafka-quickstart-processor-1.0.0-SNAPSHOT-runner
```


## ways to check
* http://localhost:8080/quotes.html
  * hit "Request quote button"
  * check consumed quotes
