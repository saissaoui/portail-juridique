package fr.artefrance.daj.ws.service.impl;


import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementStatus;
import fr.artefrance.daj.ws.service.StatementRestService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class StatementRestServiceImpl implements StatementRestService {

    @Override
    public List<Statement> getAllProducerStatement() {

        Statement statement = new Statement();

        statement.setId(1L);
        statement.setStatus(StatementStatus.PENDING);
        statement.setLastActivityDate(new Date());
        statement.setProgram(null);
        statement.setHasNoArtworks(true);
        statement.setArtworks(null);
        statement.setProducerOwnerId(2L);
        statement.setStatementRightHolders(null);

        return Collections.singletonList(statement);
    }
}
