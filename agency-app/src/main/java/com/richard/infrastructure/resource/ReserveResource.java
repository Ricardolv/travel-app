package com.richard.infrastructure.resource;

import com.richard.domain.ReserveService;
import com.richard.infrastructure.persistences.ReserveEntity;
import com.richard.infrastructure.resource.mapper.ReserveMapper;
import com.richard.infrastructure.resource.request.ReserveRequest;
import org.jboss.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

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

    @POST
    public Response newReserve(ReserveRequest reserveRequest, @Context UriInfo uriInfo) {
        ReserveEntity reserveEntity = reserveService.create(reserveRequest.nameCustomer());
        return Response.created(genericUriBuilder(reserveEntity.id, uriInfo).build())
                .build();
    }

    private UriBuilder genericUriBuilder(Long id, UriInfo uriInfo) {
        final UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(id.toString());
        LOGGER.info("New enterprise created with URI " + uriBuilder.build().toString());
        return uriBuilder;
    }
}
