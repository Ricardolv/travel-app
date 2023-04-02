package com.richard.infrastructure.resources.utils;

import org.jboss.logging.Logger;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

public class ResourceUtils {
    protected static final Logger LOGGER = Logger.getLogger(ResourceUtils.class);

    public static UriBuilder genericUriBuilder(Long id, UriInfo uriInfo) {
        final UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(id.toString());
        LOGGER.info("New enterprise created with URI " + uriBuilder.build().toString());
        return uriBuilder;
    }
}
