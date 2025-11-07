package org.acme.config;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/server")
public class ServerResource {

    @Inject                     // inject configuration property
    ServerConfig serverConfig;

    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String serverInfo() {
        return String.format("Server: %s:%d, SSL: %s, Timeout: %s, Version: %s",
            serverConfig.host(),
            serverConfig.port(),
            serverConfig.ssl(),
            serverConfig.timeout(),
            serverConfig.version().orElse("unknown")
        );
    }
}