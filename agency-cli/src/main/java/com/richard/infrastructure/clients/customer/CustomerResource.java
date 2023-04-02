package com.richard.infrastructure.clients.customer;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/customerCli")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    protected static final Logger LOGGER = Logger.getLogger(CustomerService.class);
    
    
    @Inject
    @RestClient
    CustomerService customerService;

    @GET()
    @Path("new")
    public Response newCustomer() {
        LOGGER.info("newCustomer");
        Customer customer = Customer.of(10, "Remoto");

        Response response = customerService.newCustomer(customer);

        return Response.status(Status.CREATED).entity(response.getHeaders().get("Location")).build();
    }

    @GET()
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) throws InterruptedException {
        LOGGER.info("findById");

        Response response = customerService.findById(id);

        return Response.status(Status.OK).entity(response.getEntity()).build();
    }

}
