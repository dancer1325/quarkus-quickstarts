package org.acme.getting.started;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    private static final AtomicInteger instanceCounter = new AtomicInteger(0);
    private final int instanceId;

    public GreetingResource() {
        this.instanceId = instanceCounter.incrementAndGet();
        System.out.println("GreetingResource instance created: #" + instanceId);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
