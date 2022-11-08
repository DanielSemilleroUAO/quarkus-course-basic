package org.daniel.quickstart;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
@RegisterRestClient
public interface WorldClockService {

    @GET
    @Path("/json/cet/now")
    @Produces(MediaType.APPLICATION_JSON)
    @ClientHeaderParam(name = "X-Logger", value = "DEBUG")
    WorldClock getNow(@BeanParam WorldClockHeaders worldClockHeaders);

}
