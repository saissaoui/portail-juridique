package fr.artefrance.daj.ws.service.WebServiceReader.impl;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.ws.service.WebServiceReader.WebServiceReader;

import java.io.IOException;
import java.util.List;

public class ProgramWebServiceReader implements WebServiceReader<Program> {
    @Override
    public List<Program> read(String wsReturnStringValue) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                wsReturnStringValue,
                new TypeReference<List<Program>>() {

                });
    }
}
