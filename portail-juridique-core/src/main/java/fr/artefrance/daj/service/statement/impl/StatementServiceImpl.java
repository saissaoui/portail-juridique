package fr.artefrance.daj.service.statement.impl;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementRightHolder;
import fr.artefrance.daj.domain.statement.StatementStatus;
import fr.artefrance.daj.domain.statement.artwork.Artwork;
import fr.artefrance.daj.repository.statement.StatementRepository;
import fr.artefrance.daj.service.statement.StatementService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;


public class StatementServiceImpl implements StatementService {

    @Autowired
    StatementRepository statementRepository;

    @Override
    public Statement findOneById(Long statementId) {

        return statementRepository.findOne(statementId);
    }

    @Override
    public void create(Statement statement) {
        if (statement.canBeRecorded())
            statementRepository.save(statement);
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
    public void validateStatement(Statement statement) {
        statement.checkValidation();

        statement.setStatus(StatementStatus.VALID);
        statementRepository.save(statement);
    }
}
