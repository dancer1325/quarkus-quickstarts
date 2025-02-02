package org.acme.services;

import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.consul.ServiceOptions;
import io.vertx.mutiny.ext.consul.ConsulClient;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.mutiny.core.Vertx;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class Registration {

    @ConfigProperty(name = "consul.host") String host;
    @ConfigProperty(name = "consul.port") int port;

    @ConfigProperty(name = "red-service-port", defaultValue = "9000") int red;
    @ConfigProperty(name = "blue-service-port", defaultValue = "9001") int blue;

    /**
     * Register our two services in Consul.
     *
     * Note: this method is called on a worker thread, and so it is allowed to block.
     */
    public void init(@Observes StartupEvent ev, Vertx vertx) {
        ConsulClient client = ConsulClient.create(vertx, new ConsulClientOptions().setHost(host).setPort(port));

        // Same name to register them as different instances of the same service. Different id is necessary
        client.registerServiceAndAwait(
                new ServiceOptions().setPort(blue).setAddress("localhost").setName("my-service").setId("blue"));
        client.registerServiceAndAwait(
                new ServiceOptions().setPort(red).setAddress("localhost").setName("my-service").setId("red"));
    }
}
