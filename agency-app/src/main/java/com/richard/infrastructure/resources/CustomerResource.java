package com.richard.infrastructure.resources;

import com.richard.domain.CustomerService;
import com.richard.infrastructure.persistences.CustumerEntity;
import com.richard.infrastructure.resources.mapper.CustomerMapper;
import com.richard.infrastructure.resources.request.CustomerRequest;
import org.jboss.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static com.richard.infrastructure.resources.utils.ResourceUtils.genericUriBuilder;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    protected static final Logger LOGGER = Logger.getLogger(CustomerResource.class);
    
    private final CustomerService service;
    private final CustomerMapper mapper;

    public CustomerResource(CustomerService service, CustomerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GET
    public Response listAll() {
        return Response.ok()
                .entity(mapper.toEntityList(service.findAll()))
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        return Response.ok()
                .entity(mapper.toEntity(service.findById(id)))
                .build();
    }

    @POST
    public Response newClient(CustomerRequest customerRequest, @Context UriInfo uriInfo) {
        CustumerEntity custumerEntity = service.create(mapper.toEntity(customerRequest));
        return Response.created(genericUriBuilder(custumerEntity.id, uriInfo).build())
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") long id) {
        service.deleteById(id);
        return Response.noContent().build();
    }

}