package org.acme.panache;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.Random;

/**
 * bean / EACH 5 seconds
 *      1. produce random prices
 *      2. publish | "prices" Kafka topic
 */
@ApplicationScoped
public class PriceGenerator {

    private Random random = new Random();

    // publish | "prices" Kafka topic
    @Outgoing("generated-price")
    public Multi<Integer> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .map(tick -> {
                    String callerThread = Thread.currentThread().getName();
                    System.out.println("PRODUCER (caller) thread: " + callerThread);
                    return random.nextInt(100);
                });
    }

    // publish | "prices" Kafka topic
    @Outgoing("generated-price-nonblocking")
    public Multi<Integer> generateNonBlocking() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .map(tick -> {
                    String callerThread = Thread.currentThread().getName();
                    System.out.println("PRODUCER NonBlocking (caller) thread: " + callerThread);
                    return random.nextInt(100);
                });
    }

}
