package fr.artefrance.daj.ws.service;


import fr.artefrance.daj.domain.statement.Statement;

import java.util.List;

public interface StatementRestService {
    List<Statement> producerStatementResources();

    Statement statementResource(int statement_id);

    Statement updateStatementResource(Statement statement);

    void deleteStatementResource(int statement_id);

    Statement newStatementResource(Statement statement);

}
