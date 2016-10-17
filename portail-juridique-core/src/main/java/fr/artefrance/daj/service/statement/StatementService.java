package fr.artefrance.daj.service.statement;


import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementRightHolder;
import fr.artefrance.daj.domain.statement.artwork.Artwork;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service de géstion d'un objet {@link Statement}
 */

@Service
@Transactional
public interface StatementService {
    Statement findOneById(Long statementId);

    void create(Statement statement);

    void addRightHolderToStatement(Long statementId, StatementRightHolder rightHolder);

    void addArtworkToStatement(Long statementId, Artwork artwork);

    Statement findOneWithFullDataById(Long statementId);

    void validateStatement(Statement statement);
}
