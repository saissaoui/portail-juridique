package fr.artefrance.daj.repository.statement;


import fr.artefrance.daj.domain.statement.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}
