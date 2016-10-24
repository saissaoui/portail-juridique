package fr.artefrance.daj.ws.integrationTest.rest.client;


import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.rest.client.ProgramRestService;

import java.util.List;

public interface ProgramRestServiceFake extends ProgramRestService {
    void setData(List<Program> programs);
    void setUrl(String url);
}
