package org.acme.getting.started;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class GreetingService {

    private static final AtomicInteger instanceCounter = new AtomicInteger(0);
    private final int instanceId;

    public GreetingService() {
        this.instanceId = instanceCounter.incrementAndGet();
        System.out.println("GreetingService instance created: #" + instanceId);
    }

    public String greeting(String name) {
        return "hello " + name;
    }

}
