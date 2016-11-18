package fr.artefrance.daj.rest.resources;

import fr.artefrance.daj.domain.statement.StatementRightHolder;
import fr.artefrance.daj.service.security.AuthenticationService;
import fr.artefrance.daj.service.statement.StatementService;
import oracle.jdbc.proxy.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;

@Component
@Path("/right_holders")
@Produces(MediaType.APPLICATION_JSON)
public class RightholderResourse {

    private StatementService statementService;
    private AuthenticationService authenticationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebResourceExceptionHandler.class);

    @Autowired
    public RightholderResourse(StatementService statementService, AuthenticationService authenticationService) {
        this.statementService = statementService;
        this.authenticationService = authenticationService;
    }


    @POST
    @Path("")
    public Response addRightholderToStatement(StatementRightHolder rightHolder) {
        StatementRightHolder addedRightHolder = this.statementService.addRightHolderToStatement(rightHolder.getStatementId(), rightHolder);

        LOGGER.info("added right holder "+rightHolder);

        return Response.status(CREATED)
                       .entity(addedRightHolder)
                       .build();

    }

}
