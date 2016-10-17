package fr.artefrance.daj.ws.integrationTest.config.infrastructure.rest.client;

import fr.artefrance.daj.ws.infrastructure.rest.client.JerseyClient;
import fr.artefrance.daj.ws.rest.dto.ProgramDTO;

import java.util.List;


public interface JerseyClientFake extends JerseyClient {
    void setData(List<ProgramDTO> programs);
}
