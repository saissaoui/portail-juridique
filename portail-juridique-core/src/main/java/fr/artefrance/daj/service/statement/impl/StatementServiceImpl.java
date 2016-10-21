package fr.artefrance.daj.service.statement.impl;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementRightHolder;
import fr.artefrance.daj.domain.statement.StatementStatus;
import fr.artefrance.daj.domain.statement.artwork.Artwork;
import fr.artefrance.daj.repository.statement.StatementRepository;
import fr.artefrance.daj.service.statement.StatementService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatementServiceImpl implements StatementService {

    @Autowired
    StatementRepository statementRepository;

    @Override
    public Statement findOneById(Long statementId) {

        return statementRepository.findOne(statementId);
    }

    @Override
    public Statement create(Statement statement) {
        return statementRepository.save(statement);
    }

    @Override
    public void addRightHolderToStatement(Long statementId, StatementRightHolder rightHolder) {

        Statement statement = statementRepository.getOne(statementId);

        if (CollectionUtils.isEmpty(statement.getRightHolders()))
            statement.setRightHolders(new ArrayList());

        statement.getRightHolders().add(rightHolder);

        statementRepository.save(statement);
    }

    @Override
    public void addArtworkToStatement(Long statementId, Artwork artwork) {

        Statement statement = statementRepository.getOne(statementId);
        if (CollectionUtils.isEmpty(statement.getArtworks()))
            statement.setArtworks(new ArrayList());

        statement.getArtworks().add(artwork);

        statementRepository.save(statement);
    }

    @Override
    public Statement findOneWithFullDataById(Long statementId) {

        Statement statement = statementRepository.findOne(statementId);
        Hibernate.initialize(statement.getArtworks());
        Hibernate.initialize(statement.getRightHolders());
        return statement;
    }

    @Override
    public Statement validateStatement(Statement statement) {
        checkForValidation(statement);
        statement.setStatus(StatementStatus.VALID);
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
     * @param statement
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
