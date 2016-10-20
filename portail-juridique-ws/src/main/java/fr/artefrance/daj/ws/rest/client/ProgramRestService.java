package fr.artefrance.daj.ws.rest.client;


import fr.artefrance.daj.domain.security.User;
import fr.artefrance.daj.domain.statement.Program;

import java.io.IOException;
import java.util.List;

public interface ProgramRestService {

    List<Program> getProducerProgramsFromSophia(User producer) throws IOException;
}
