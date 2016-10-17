package fr.artefrance.daj.repository.statement.artwork;

import fr.artefrance.daj.domain.rightholder.RightHolderRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<RightHolderRole, Long> {
}
