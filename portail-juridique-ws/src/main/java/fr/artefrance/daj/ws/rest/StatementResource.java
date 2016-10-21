package fr.artefrance.daj.ws.rest;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.service.statement.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

@Component
@Path("/statements")
@Produces(MediaType.APPLICATION_JSON)
public class StatementResource {

    private StatementService statementService;

    @Autowired
    public StatementResource(StatementService statementService) {
        this.statementService = statementService;
    }

    @GET
    @Path("/")
    public Response producerStatements() {

        List<Statement> statements = this.statementService.findAllProducerStatements();
        System.out.println("statements = " + statements);

        return Response.status(OK)
                       .entity(statements)
                       .build();
    }

    @GET
    @Path("/{statement_id}")
    public Response statement(@PathParam("statement_id") int statement_id) {

        Statement statement = this.statementService.findOneById((long) statement_id);
        System.out.println("statement = " + statement);

        return Response.status(OK)
                       .entity(statement)
                       .build();
    }

    @PUT
    @Path("{statement_id}/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validateStatement(Statement statement) {

        Statement updatedStatement = this.statementService.validateStatement(statement);
        System.out.println("updatedStatement = " + updatedStatement);

        return Response.status(OK)
                       .entity(updatedStatement)
                       .build();
    }

    @DELETE
    @Path("{statement_id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteStatement(@PathParam("statement_id") int statement_id) {

        this.statementService.findOneById(1L);

        return Response.status(NO_CONTENT)
                       .header(HttpHeaders.LOCATION, statement_id)
                       .build();
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStatement(Statement statement) {

        Statement createdStatement = this.statementService.create(statement);
        System.out.println("createdStatement = " + createdStatement);
        return Response.status(CREATED)
                       .header(HttpHeaders.LOCATION, "statements/" + createdStatement.getId())
                       .build();
    }


}
