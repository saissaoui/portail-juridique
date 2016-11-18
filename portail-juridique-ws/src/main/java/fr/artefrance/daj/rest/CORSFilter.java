package fr.artefrance.daj.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 *filter d'ajout de headers CORS
 */
@Provider
@Component
public class CORSFilter implements ContainerResponseFilter {

    @Value(value = "${portail-juridique.web-client-domain}")
    private String WEB_CLIENT_DOMAIN;

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext
            containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", WEB_CLIENT_DOMAIN);
        containerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        containerResponseContext.getHeaders().add("Accept", "*");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Headers", "content-type");

    }
}
