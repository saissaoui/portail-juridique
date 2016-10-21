package fr.artefrance.daj.ws.integrationTest.config;

import fr.artefrance.daj.ws.integrationTest.rest.client.ProgramRestServiceFake;
import fr.artefrance.daj.ws.integrationTest.rest.client.impl.ProgramRestServiceFakeImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@Configuration
public class IntegrationTestConfig {

    @Bean(destroyMethod = "shutdown")
    DataSource dataSource() {
        return null;
    }

    @Bean
    ProgramRestServiceFake programRestServiceFake() {
        return new ProgramRestServiceFakeImpl();
    }
}
