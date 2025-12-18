package org.acme.rest.client;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletionStage;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.core.MultivaluedMap;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

import io.smallrye.mutiny.Uni;

@Path("/extensions")
@RegisterRestClient(configKey = "extensions-api")
public interface ExtensionsService {

    @GET
    Set<Extension> getAll();

    @GET
    Set<Extension> getById(@RestQuery String id);

    // async
    @GET
    CompletionStage<Set<Extension>> getByIdAsync(@RestQuery String id);

    // async
    @GET
    Uni<Set<Extension>> getByIdAsUni(@RestQuery String id);

    @GET
    Set<Extension> getByName(@RestQuery String name);

    @GET
    Set<Extension> getByOptionalName(@RestQuery Optional<String> name);

    // 1 query parameter / EACH Map's entry
    @GET
    Set<Extension> getByFilter(@RestQuery Map<String, String> filter);

    // MultivaluedMap<>
    //      allows sending array values
    @GET
    Set<Extension> getByFilters(@RestQuery MultivaluedMap<String, String> filters);
}
