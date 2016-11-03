package fr.artefrance.daj.rest.resources;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.service.security.AuthenticationService;
import fr.artefrance.daj.service.statement.StatementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private StatementService statementService;
    private AuthenticationService authenticationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebResourceExceptionHandler.class);

    @Autowired
    public StatementResource(StatementService statementService, AuthenticationService authenticationService) {
        this.statementService = statementService;
        this.authenticationService = authenticationService;
    }

    @GET
    @Path("/")
    public Response producerStatements() {

        List<Statement> statements = this.statementService.findAllProducerStatements();
        LOGGER.info("statements = " + statements);

        return Response.status(OK)
                       .entity(statements)
                       .build();
    }

    @GET
    @Path("/archived")
    public Response producerArchivedStatements() {

        List<Statement> producerArchivedStatements = this.statementService.findArchivedStatementsByProducerId(
                this.authenticationService.getCurrentUser().getId());
        LOGGER.info("producerArchivedStatements = " + producerArchivedStatements);

        return Response.status(OK)
                       .entity(producerArchivedStatements)
                       .build();
    }

    @GET
    @Path("/{statementId}")
    public Response statement(@PathParam("statementId") int statementId) {

        Statement statement = this.statementService.findStatementById((long) statementId);
        LOGGER.info("statement = " + statement);

        return Response.status(OK)
                       .entity(statement)
                       .build();
    }

    @PUT
    @Path("{statementId}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStatement(Statement statement) {

        Statement updatedStatement = this.statementService.updateStatement(statement);
        LOGGER.info("updatedStatement = " + updatedStatement);

        return Response.status(OK)
                       .entity(updatedStatement)
                       .build();
    }

    @PUT
    @Path("{statementId}/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validateStatement(Statement statement) {

        Statement validatedStatement = this.statementService.validateStatement(statement);
        LOGGER.info("validatedStatement = " + validatedStatement);

        return Response.status(OK)
                       .entity(validatedStatement)
                       .build();
    }

    @DELETE
    @Path("{statementId}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteStatement(@PathParam("statementId") int statementId) {

        this.statementService.findStatementById(1L);

        return Response.status(NO_CONTENT)
                       .header(HttpHeaders.LOCATION, statementId)
                       .build();
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStatement(Statement statement) {

        Statement createdStatement = this.statementService.create(statement);
        LOGGER.info("createdStatement = " + createdStatement);
        return Response.status(CREATED)
                       .header(HttpHeaders.LOCATION, "statements/" + createdStatement.getId())
                       .build();
    }

}
