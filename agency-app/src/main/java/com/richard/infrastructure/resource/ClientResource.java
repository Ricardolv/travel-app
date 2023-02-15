package com.richard.infrastructure.resource;

import com.richard.domain.ClientService;
import com.richard.infrastructure.persistences.ClientEntity;
import com.richard.infrastructure.resource.mapper.ClientMapper;
import com.richard.infrastructure.resource.request.ClientRequest;
import org.jboss.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
    protected static final Logger LOGGER = Logger.getLogger(ClientResource.class);

    private final ClientService service;
    private final ClientMapper mapper;

    public ClientResource(ClientService service, ClientMapper mapper) {
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
    public Response findById(@QueryParam("id") long id) {
        return Response.ok()
                .entity(mapper.toEntity(service.findById(id)))
                .build();
    }

    @POST
    public Response newClient(ClientRequest clientRequest, @Context UriInfo uriInfo) {
        ClientEntity clientEntity = service.create(mapper.toEntity(clientRequest));
        return Response.created(genericUriBuilder(clientEntity.id, uriInfo).build())
                .build();
    }

    @DELETE
    public Response deleteById(@QueryParam("id") long id) {
        service.deleteById(id);
        return Response.noContent().build();
    }

    private UriBuilder genericUriBuilder(Long id, UriInfo uriInfo) {
        final UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(id.toString());
        LOGGER.info("New enterprise created with URI " + uriBuilder.build().toString());
        return uriBuilder;
    }

}