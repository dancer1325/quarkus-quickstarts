package org.acme.panache;

import io.smallrye.reactive.messaging.annotations.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PriceStorage {

    /**
     * goal
     *      1. consumes Kafka topic "prices" messages
     *      2. stores the price | database
     * Classic Hibernate is blocking (!= Hibernate Reactive) -> we would need the @Blocking annotation
     *      BUT ALREADY included -- via -- @Transactional
     * @param priceInUsd  the price
     */
    @Incoming("prices")
    // @Blocking            // comment it & it works
    @Transactional
    public void store(int priceInUsd) {
        System.out.println("Thread: " + Thread.currentThread().getName() + 
                          " - Storing price: " + priceInUsd);
        Price price = new Price();
        price.value = priceInUsd;
        price.persist();        // .persist         Hibernate + Panache
    }

    // NON @Blocking
    @Incoming("pricesNonBlocking")
    public void logThread(int priceInUsd) {
        System.out.println("Thread - WITHOUT @Blocking: " + Thread.currentThread().getName() +
                          " - Price: " + priceInUsd);
    }

}
