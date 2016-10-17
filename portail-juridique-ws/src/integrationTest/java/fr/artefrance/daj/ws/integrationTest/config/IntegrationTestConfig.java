package fr.artefrance.daj.ws.integrationTest.config;

import fr.artefrance.daj.ws.integrationTest.config.infrastructure.rest.client.JerseyClientFake;
import fr.artefrance.daj.ws.integrationTest.config.infrastructure.rest.client.impl.JerseyClientFakeImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegrationTestConfig {

    @Bean
    JerseyClientFake jerseyClient() {
        return new JerseyClientFakeImpl();
    }
}
