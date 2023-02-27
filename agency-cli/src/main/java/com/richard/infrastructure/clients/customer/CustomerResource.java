package com.richard.infrastructure.clients.customer;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/customerCli")
public class CustomerResource {
    protected static final Logger LOGGER = Logger.getLogger(CustomerService.class);
    
    
    @Inject
    @RestClient
    CustomerService customerService;

    @GET()
    @Path("newCustomer")
    public Response newCustomer() {
        LOGGER.info("newCustomer");
        Customer customer = Customer.of(10, "Remoto");

        Response response = customerService.newCustomer(customer);

        

        return Response.status(Status.CREATED).build();
    }

}
