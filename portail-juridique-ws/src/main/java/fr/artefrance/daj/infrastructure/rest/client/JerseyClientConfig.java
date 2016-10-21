package fr.artefrance.daj.infrastructure.rest.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Configuration
public class JerseyClientConfig {

    @Bean
    Client jerseyClient() {
        return ClientBuilder.newClient();
    }
}
