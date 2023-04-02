package com.richard.infrastructure.resources;

import com.richard.domain.ReserveService;
import com.richard.infrastructure.persistences.ReserveEntity;
import com.richard.infrastructure.resources.mapper.ReserveMapper;
import com.richard.infrastructure.resources.request.ReserveRequest;
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

@Path("/reservations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReserveResource {

    protected static final Logger LOGGER = Logger.getLogger(ReserveResource.class);
    private final ReserveService reserveService;
    private final ReserveMapper mapper;

    public ReserveResource(ReserveService reserveService, ReserveMapper mapper) {
        this.reserveService = reserveService;
        this.mapper = mapper;
    }

    @GET
    public Response getAll() {
        return Response.ok(mapper.toEntityList(reserveService.findAll())).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        return Response.ok()
                .entity(mapper.toEntity(reserveService.findById(id)))
                .build();
    }

    @POST
    public Response newReserve(ReserveRequest reserveRequest, @Context UriInfo uriInfo) {
        ReserveEntity reserveEntity = reserveService.create(reserveRequest.codeCustomer());
        return Response.created(genericUriBuilder(reserveEntity.id, uriInfo).build())
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") long id) {
        reserveService.deleteById(id);
        return Response.noContent().build();
    }

}
