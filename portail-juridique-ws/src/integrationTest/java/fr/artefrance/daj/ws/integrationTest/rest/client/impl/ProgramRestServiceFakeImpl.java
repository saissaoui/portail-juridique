package fr.artefrance.daj.ws.integrationTest.rest.client.impl;

import fr.artefrance.daj.domain.security.User;
import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.ws.integrationTest.rest.client.ProgramRestServiceFake;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProgramRestServiceFakeImpl implements ProgramRestServiceFake {

    private List<Program> programs;
    private String url;

    private List<String> authorizedURI = Arrays.asList(
            "http://localhost:8080/right_program_ws",
            "http://localhost:8080/another_right_ws_service"
                                                      );

    @Override
    public List<Program> getProducerProgramsFromSophia(Long id) throws IOException {
        if(authorizedURI.contains(this.url)) {
            return this.programs;
        } else {
            throw new IOException("Resource not found!");
        }
    }

    @Override
    public void setData(List<Program> programs) {
        this.programs = programs;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }
}
