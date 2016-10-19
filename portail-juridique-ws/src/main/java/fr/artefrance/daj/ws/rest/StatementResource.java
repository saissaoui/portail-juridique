package fr.artefrance.daj.ws.rest;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.ws.service.StatementRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

@Component
@Path("/statements")
@Produces(MediaType.APPLICATION_JSON)
public class StatementResource {

    private StatementRestService statementRestService;

    @Autowired
    public StatementResource(StatementRestService statementRestService) {
        this.statementRestService = statementRestService;
    }

    @GET
    @Path("/")
    public Response producerStatements() {

        List<Statement> statements = this.statementRestService.producerStatementResources();

        return Response.status(OK)
                .entity(statements)
                .build();
    }

    @GET
    @Path("/{statement_id}")
    public Response statement(@PathParam("statement_id") int statement_id) {

        Statement statement = this.statementRestService.statementResource(statement_id);

        return Response.status(OK)
                       .entity(statement)
                       .build();
    }

    @PUT
    @Path("{statement_id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStatement(Statement statement) {

        Statement updatedStatement = this.statementRestService.updateStatementResource(statement);

        return Response.status(OK)
                       .entity(updatedStatement)
                       .build();
    }

    @DELETE
    @Path("{statement_id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteStatement(@PathParam("statement_id") int statement_id) {

        this.statementRestService.deleteStatementResource(statement_id);

        return Response.status(NO_CONTENT)
                       .header(HttpHeaders.LOCATION, statement_id)
                       .build();
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStatement(Statement statement) {

        Statement createdStatement = this.statementRestService.newStatementResource(statement);

        return Response.status(CREATED)
                       .header(HttpHeaders.LOCATION, createdStatement.getId())
                       .build();
    }


}
