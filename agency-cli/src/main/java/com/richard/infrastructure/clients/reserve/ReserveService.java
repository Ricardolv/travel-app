package com.richard.infrastructure.clients.reserve;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.temporal.ChronoUnit;

@RegisterRestClient(baseUri = "http://localhost:8182/reservations")
public interface ReserveService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Timeout(unit = ChronoUnit.SECONDS, value = 3)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = 0.5,
            delay = 6000,
            successThreshold = 1
    )
    Response findById(@PathParam("id") long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response newReserve(Reserve Reserve);

    private Reserve fallback(long id) {
        return Reserve.of(0L);
    }
}
