package fr.artefrance.daj.service.statement;


import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementRightHolder;
import fr.artefrance.daj.domain.statement.artwork.Artwork;

import java.util.List;

/**
 * Service de géstion d'un objet {@link Statement}
 */
public interface StatementService {
    Statement findOneById(Long statementId);

    Statement create(Statement statement);

    void addRightHolderToStatement(Long statementId, StatementRightHolder rightHolder);

    void addArtworkToStatement(Long statementId, Artwork artwork);

    Statement validateStatement(Statement statement);

    List<Statement> findAllProducerStatements();

    List<Statement> findArchivedStatementsByProducerId(Long producerId);
}
