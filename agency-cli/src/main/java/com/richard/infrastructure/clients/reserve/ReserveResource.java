package com.richard.infrastructure.clients.reserve;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reserveCli")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReserveResource {

    protected static final Logger LOGGER = Logger.getLogger(ReserveResource.class);

    @Inject
    @RestClient
    ReserveService reserveService;

    @GET()
    @Path("new")
    public Response newCustomer() {
        LOGGER.info("newCustomer");
        Reserve reserve = Reserve.of("ReserveRemoto");

        Response response = reserveService.newReserve(reserve);

        return Response.status(Response.Status.CREATED).entity(response.getHeaders().get("Location")).build();
    }

}
