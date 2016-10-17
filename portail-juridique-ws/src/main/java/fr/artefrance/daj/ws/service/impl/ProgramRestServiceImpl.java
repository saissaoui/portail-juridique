package fr.artefrance.daj.ws.service.impl;

import fr.artefrance.daj.domain.security.User;
import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.ws.infrastructure.rest.client.JerseyClient;
import fr.artefrance.daj.ws.service.ProgramRestService;
import fr.artefrance.daj.ws.service.WebServiceReader.impl.ProgramWebServiceReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;

public class ProgramRestServiceImpl implements ProgramRestService {

    @Value("portail-juridique.sophia.web-service-url")
    private String SOPHIA_WS_URL;

    @Value("portail-juridique.sophia.producer-programs-service")
    private String SOPHIA_WS_PRODUCER_PROGRAMS_SERVICE;

    @Autowired
    JerseyClient jerseyClient;

    @Override
    public List<Program> getProducerProgramsFromSophia(User producer) throws IOException {

        String wsReturnStringValue = jerseyClient.callWebService(SOPHIA_WS_URL, SOPHIA_WS_PRODUCER_PROGRAMS_SERVICE);
        ProgramWebServiceReader reader = new ProgramWebServiceReader();

        return reader.read(wsReturnStringValue);
    }
}
