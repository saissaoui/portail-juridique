package fr.artefrance.daj.repository.statement;

import fr.artefrance.daj.domain.statement.Statement;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatementRepository extends JpaRepository<Statement, Long> {

    @Query("SELECT DISTINCT s FROM Statement s WHERE s.producerOwnerId = ?1 AND s.status = 'VALID'")
    List<Statement> findArchivedStatementsByProducerId(Long producerId);

    @EntityGraph(attributePaths = {"rightHolders", "artworks"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT DISTINCT s FROM Statement s ")
    List<Statement> findAll();

    @EntityGraph(attributePaths = {"rightHolders", "artworks"}, type = EntityGraph.EntityGraphType.LOAD)
    Statement findOne(Long statementId);
}
