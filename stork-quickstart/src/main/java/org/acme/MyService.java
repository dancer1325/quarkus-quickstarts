package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The REST Client interface.
 *
 * Notice the `baseUri`. It uses `stork://` as URL scheme indicating that the called
 * service uses Stork to locate and select the service instance. The `my-service`
 * part is the service name. This is used to configure Stork discovery
 * and selection in the `application.properties` file.
 * The `baseUri` is processed by StorkClientRequestFilter which it's a Rest filter
 */
@RegisterRestClient(baseUri = "stork://my-service")
public interface MyService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String get();
}
