package fr.artefrance.daj.rest;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 *filter d'ajout de headers CORS
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext
            containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        containerResponseContext.getHeaders().add("Accept", "*");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Headers", "content-type");

    }
}
