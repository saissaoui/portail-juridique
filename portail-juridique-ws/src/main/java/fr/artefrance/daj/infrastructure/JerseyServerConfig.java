package fr.artefrance.daj.infrastructure;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyServerConfig extends ResourceConfig {

    public JerseyServerConfig() {
        packages("fr.artefrance.daj.rest");
    }

}
