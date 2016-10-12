package fr.artefrance.daj.repository.statement;

import fr.artefrance.daj.domain.statement.Artwork;
import fr.artefrance.daj.domain.statement.GranteeRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GranteeRoleRepository extends JpaRepository<GranteeRole, Long> {
}
