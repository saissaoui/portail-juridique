package fr.artefrance.daj.ws.integrationTest.config.infrastructure.rest.client.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import fr.artefrance.daj.ws.infrastructure.rest.client.impl.URIBuilder;
import fr.artefrance.daj.ws.integrationTest.config.infrastructure.rest.client.JerseyClientFake;
import fr.artefrance.daj.ws.rest.dto.ProgramDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class JerseyClientFakeImpl implements JerseyClientFake {

    private ObjectMapper objectMapper;
    private List<ProgramDTO> programs;
    private List<String> recognizeWebServices = Arrays.asList(
                "http://localhost:8080/right_program_ws",
                "http://localhost:8080/service_one",
                "http://localhost:8080/service_two");

    public JerseyClientFakeImpl() {
        this.programs = new ArrayList<>();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String callWebService(String serviceUrl, String serviceName, Object params) throws IOException {
        Optional<String> uri = Optional.of(URIBuilder.INSTANCE.buildURI(serviceUrl, serviceName))
                                       .filter(buildUri -> recognizeWebServices.contains(buildUri));
        if(!uri.isPresent()) {
            throw new IOException("Erreur 404!");
        }
        return objectMapper.writeValueAsString(programs);
    }

    @Override
    public String callWebService(String serviceUrl, String serviceName) throws IOException {
        return callWebService(serviceUrl, serviceName, null);
    }

    @Override
    public void setData(List<ProgramDTO> programs) {
        this.programs = programs;
    }
}
