package org.acme.rest.client;

import io.quarkus.rest.client.reactive.ClientQueryParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.Set;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/extensions")
@RegisterRestClient(configKey = "extensions-client-query-param")
// 1. configuration property / affect ALL interface's methods
@ClientQueryParam(name = "keywords", value = "${my.param}")
public interface ExtensionsClientQueryParamService {

    // TODO: why does it NOT filter by keywords = ${my.param} ?
    @GET
    Set<Extension> getWithParam();

    // 2. constant
    @GET
    // TODO: why does it NOT filter by keywords = ${my.param} + name="Amazon Textract" ?
    @ClientQueryParam(name = "name", value = "Amazon Textract")
    Set<Extension> getWithOtherParam();

    // 3. invoking a method
    @GET
    // TODO: why does it NOT filter by keywords = ${my.param} + name="Qute Web" ?
    @ClientQueryParam(name = "name", value = "{withParam}")
    Set<Extension> getFromMethod();

    default String withParam(String name) {
        if ("name" == name) {
            return "Qute Web";
        }
        throw new IllegalArgumentException();
    }
}
