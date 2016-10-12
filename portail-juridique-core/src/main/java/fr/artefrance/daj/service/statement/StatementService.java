package fr.artefrance.daj.service.statement;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.repository.statement.ProgramRepository;
import fr.artefrance.daj.repository.statement.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatementService {

    @Autowired
    StatementRepository statementRepository;


    @Transactional
    public void create(Statement statement) {
        statementRepository.save(statement);
    }
}
