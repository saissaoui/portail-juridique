package fr.artefrance.daj.service.statement.impl;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementRightHolder;
import fr.artefrance.daj.domain.statement.StatementStatus;
import fr.artefrance.daj.domain.statement.artwork.Artwork;
import fr.artefrance.daj.repository.statement.StatementRepository;
import fr.artefrance.daj.service.statement.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional
public class StatementServiceImpl implements StatementService {

    @Autowired
    StatementRepository statementRepository;

    @Override
    public Statement findStatementById(Long statementId) {
        return statementRepository.findOne(statementId);
    }

    @Override
    public Statement create(Statement statement) {
        return statementRepository.save(statement);
    }

    @Override
    public void addRightHolderToStatement(Long statementId, StatementRightHolder rightHolder) {
        Statement statement = statementRepository.getOne(statementId);
        statement.addStatementRightHolder(rightHolder);
    }

    @Override
    public void addArtworkToStatement(Long statementId, Artwork artwork) {
        Statement statement = statementRepository.getOne(statementId);
        statement.addArtwork(artwork);
    }

    @Override
    public Statement validateStatement(Statement statement) {
        checkForValidation(statement);
        statement.setStatus(StatementStatus.VALID);
        return statementRepository.save(statement);

    }

    @Override
    public Statement updateStatement(Statement statement) {
        return statementRepository.save(statement);
    }

    @Override
    public List<Statement> findAllProducerStatements() {
        return statementRepository.findAll();
    }

    @Override
    public List<Statement> findArchivedStatementsByProducerId(Long producerId) {
        return statementRepository.findArchivedStatementsByProducerId(producerId);
    }

    /**
     * Verifie si un objet {@link Statement} peut être passé au statut validé
     * @param statement l'objet relevé à vérifier
     */
    private void checkForValidation(Statement statement) {
        Assert.notNull(statement);
        Assert.notEmpty(statement.getRightHolders(), "Statement.rightHolders can not be empty");
        Assert.isTrue(statement.getRightHolders().size() > 1, "Statement.rightHolders should contain at less two " +
                "right holders");
        Assert.isTrue(statement.getHasNoArtworks() || statement.getArtworks() != null && !statement.getArtworks()
                                                                                                   .isEmpty(),
                      "Statement should contain artworks");
    }

}
