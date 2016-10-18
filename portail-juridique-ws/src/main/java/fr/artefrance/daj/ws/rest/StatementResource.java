package fr.artefrance.daj.ws.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.ws.service.StatementRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/statements")
public class StatementResource {

    private StatementRestService statementRestService;
    private ObjectMapper objectMapper;

    @Autowired
    public StatementResource(StatementRestService statementRestService) {
        this.statementRestService = statementRestService;
        this.objectMapper = new ObjectMapper();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {

        List<Statement> statements = this.statementRestService.getAllProducerStatement();

        return Response.status(Response.Status.OK)
                .entity(statements)
                .build();
    }
}
