package fr.artefrance.daj.repository.statement.artwork;

import fr.artefrance.daj.domain.statement.artwork.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
}
