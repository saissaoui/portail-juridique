package fr.artefrance.daj.repository.statement;


import fr.artefrance.daj.domain.rightholder.RightHolderRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRightHolder extends JpaRepository<RightHolderRole, Long> {
}
