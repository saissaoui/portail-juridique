package fr.artefrance.daj.ws.infrastructure.rest.server;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyServerConfig extends ResourceConfig {

    public JerseyServerConfig() {
        packages("fr.artefrance.daj.ws.rest");
    }

}
