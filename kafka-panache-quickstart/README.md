Quarkus Kafka/Panache Quickstart
================================

* goal
  * interact with 
    * -- , via MicroProfile Reactive Messaging, -- Apache Kafka
    * -- , via Panache, -- Hibernate 

* components 
  * used
    * RESTEasy Reactive
    * Reactive Messaging + Kafka connector 
    * (Classic) Hibernate with Panache

* vs [kafka-panache-reactive-quickstart](../kafka-panache-reactive-quickstart)
  * Hibernate vs Hibernate Reactive

## + blocking processing (`@Blocking`)
### use cases: database interactions
* this whole project
  * [PriceResource.java](src/main/java/org/acme/panache/PriceResource.java)
  * [PriceStorage.java](src/main/java/org/acme/panache/PriceStorage.java)
### == processing should NOT run | caller thread
* [run](#how-to-run--dev-mode) 
* check logs
  * "PRODUCER..." -- PriceGenerator -- 
    * == caller thread use executor-thread
  * "Thread " -- blocking processing == consumer --
    * use worker-thread
      * != executor-thread

## Kafka connector
### by default, use worker threads
* [run it](#how-to-run--dev-mode)
* check logs "Thread:" & "Thread - WITHOUT @Blocking: " get "vert.x-worker-thread"

## EXISTING `@Blocking` annotations
### `io.smallrye.reactive.messaging.annotations.Blocking`
* [PriceStorage](src/main/java/org/acme/panache/PriceStorage.java)
### `io.smallrye.common.annotation.Blocking`
* [PriceResource](src/main/java/org/acme/panache/PriceResource.java)

## `@Transactional`
### uses | method
* [PriceStorage](src/main/java/org/acme/panache/PriceStorage.java)
### ALTHOUGH you do NOT use `@Blocking` -> AUTOMATICALLY _block_
* [PriceStorage](src/main/java/org/acme/panache/PriceStorage.java)
  * commented `@Blocking`
  * [run it](#how-to-run--dev-mode)
  * it STILL works

## how to run | dev mode?
* `mvn quarkus:dev`
  * Problems:
    * Problem1: "Previous attempts to find a Docker environment failed. Will not retry. Please see logs and check configuration"
      * Attempt1: `docker compose up -d`
      * Solution: disable DEV services | [application.properties](src/main/resources/application.properties)
    * Problem2: "Bean is not active: SYNTHETIC bean [class=io.agroal.api.AgroalDataSource"
      * Solution: configure database & kafka | [application.properties](src/main/resources/application.properties)

## how to run | native?

* `docker-compose up -d`
* `mvn clean install -Pnative`
  * Problems:
    * Problem1: "Previous attempts to find a Docker environment failed. Will not retry. Please see logs and check configuration"
      * Solution: TODO:
* `./target/kafka-panache-quickstart-1.0.0-SNAPSHOT-runner`
