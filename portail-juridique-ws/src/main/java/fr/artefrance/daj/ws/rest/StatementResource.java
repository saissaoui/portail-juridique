package fr.artefrance.daj.ws.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/statements")
public class StatementResource {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "";
    }
}
