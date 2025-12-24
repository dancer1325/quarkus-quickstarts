package org.acme.panache;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import io.smallrye.common.annotation.Blocking;

@Path("/prices")
public class PriceResource {

    /**
     * @return the list of prices
     */
    @GET
    @Blocking
    public List<Price> getAllPrices() {
        return Price.listAll();     // .listAll()       classic Hibernate -> blocking   -> we need to use @Blocking
    }

    // TODO: check if it works
    /*@GET
    @Path("/nonblocking")
    public List<Price> getNonBlockingAllPrices() {
        return Price.listAll();
    }*/
}
