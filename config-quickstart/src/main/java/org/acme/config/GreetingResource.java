package org.acme.config;

import java.util.Optional;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/greeting")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message")  // NO default value & you do NOT provide one -> throws an error
    String message;

    @Inject
    @ConfigProperty(name = "greeting.suffix", defaultValue = "!")       // default value provided   -> NOT required to set
    String suffix;

    @ConfigProperty(name = "greeting.name") // if you do NOT provide a value -> NOT throw an error  -- Reason OPTIONAL --
    Optional<String> name;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        //return "Hello"        // ALTERNATIVE to hardcode values
        return message + " " + name.orElse("world") + suffix;

    }
}
