package fr.artefrance.daj.rest.client;


import fr.artefrance.daj.domain.statement.Program;

import java.io.IOException;
import java.util.List;

public interface ProgramRestService {

    List<Program> getProducerProgramsFromSophia(Long id) throws IOException;
}
