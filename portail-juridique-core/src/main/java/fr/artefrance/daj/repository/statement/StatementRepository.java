package fr.artefrance.daj.repository.statement;

import fr.artefrance.daj.domain.statement.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatementRepository extends JpaRepository<Statement, Long> {

    @Query("select s from Statement s where s.producerOwnerId = ?1 and s.status = 'VALID'")
    List<Statement> findArchivedStatementsByProducerId(Long producerId);
}
