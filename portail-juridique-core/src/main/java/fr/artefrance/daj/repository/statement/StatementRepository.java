package fr.artefrance.daj.repository.statement;

import fr.artefrance.daj.domain.statement.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository<Statement, Long> {
}
