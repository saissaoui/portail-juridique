package fr.artefrance.daj.rest.client.impl;

import fr.artefrance.daj.domain.security.User;
import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.rest.client.ProgramRestService;
import org.glassfish.jersey.client.JerseyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

public class ProgramRestServiceImpl implements ProgramRestService {

    @Value("portail-juridique.sophia.ws-url")
    private String SOPHIA_WS_URL;

    @Value("portail-juridique.sophia.producer-programs-service")
    private String SOPHIA_WS_PRODUCER_PROGRAMS_SERVICE;

    @Autowired
    JerseyClient jerseyClient;

    @Override
    public List<Program> getProducerProgramsFromSophia(Long id) throws IOException {

        return jerseyClient.target(SOPHIA_WS_URL)
                           .path(SOPHIA_WS_PRODUCER_PROGRAMS_SERVICE)
                           .request(MediaType.APPLICATION_JSON_TYPE)
                           .get(new GenericType<List<Program>>() {
                           });
    }
}
