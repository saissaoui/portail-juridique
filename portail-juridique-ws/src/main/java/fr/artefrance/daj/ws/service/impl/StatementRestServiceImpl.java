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

    private StatementFactoryStub stub;

    public StatementRestServiceImpl() {
        this.stub = new StatementFactoryStub();
    }

    @Override
    public List<Statement> producerStatementResources() {
        return Collections.singletonList(this.stub.createStatement());
    }

    @Override
    public Statement statementResource(int statement_id) {
        return this.stub.createStatement();
    }

    @Override
    public Statement newStatementResource(Statement statement) {
        System.out.println(statement);
        return statement;
    }

    @Override
    public Statement updateStatementResource(Statement statement) {
        System.out.println(statement);
        return statement;
    }

    @Override
    public void deleteStatementResource(int statement_id) {
        System.out.println("Statement resource deleted : " + statement_id);
    }


    /**
     * Class de Test
     */
    private class StatementFactoryStub {

        Statement createStatement() {
            Statement statement = new Statement();

            statement.setId(1L);
            statement.setStatus(StatementStatus.PENDING);
            statement.setLastActivityDate(new Date());
            statement.setProgram(null);
            statement.setHasNoArtworks(true);
            statement.setArtworks(null);
            statement.setProducerOwnerId(2L);
            statement.setStatementRightHolders(null);

            return statement;
        }
    }
}
