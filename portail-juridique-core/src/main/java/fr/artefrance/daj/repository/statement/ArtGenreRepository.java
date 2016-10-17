package fr.artefrance.daj.repository.statement;

import fr.artefrance.daj.domain.statement.ArtGenre;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArtGenreRepository extends JpaRepository<ArtGenre, String> {
}
