package fr.artefrance.daj.ws.service.impl;


import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.ws.service.StatementRestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementRestServiceImpl implements StatementRestService {

    @Override
    public List<Statement> getAllProducerStatement() {
        return null;
    }
}
