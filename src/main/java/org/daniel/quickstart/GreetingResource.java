package org.daniel.quickstart;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    Logger logger = Logger.getLogger(GreetingResource.class);
    @Inject
    GreetingsService service;

    @Inject
    @RestClient
    WorldClockService worldClockService;

    @Inject
    ExpensiveService expensiveService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return service.toUpperCase();
    }

    @GET
    @Path("expensive")
    @Produces(MediaType.TEXT_PLAIN)
    public int helloExpensive() {
        return expensiveService.calculate();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBeer(@Valid Beer beer) {
        System.out.println(beer);
        return Response.ok().build();
    }

    @GET
    @Path("beer")
    @Produces(MediaType.APPLICATION_JSON)
    public Beer getBeer() {
        logger.debug("Hello from debug");
        return new Beer("prueba", 300);
    }

    @GET
    @Path("clock")
    @Produces(MediaType.APPLICATION_JSON)
    public WorldClock getNow() {
        WorldClockHeaders worldClockHeaders = new WorldClockHeaders();
        worldClockHeaders.logger = "DEBUG";
        return worldClockService.getNow(worldClockHeaders);
    }

    @GET
    @Path("clock2")
    @Produces(MediaType.APPLICATION_JSON)
    public WorldClock getNow2() {
        return ClientBuilder.newClient().target("http://worldclockapi.com").path("/api/json/cet/now").request().get(WorldClock.class);
    }
}