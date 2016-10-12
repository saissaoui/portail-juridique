package fr.artefrance.daj.integrationTest.config;

import fr.artefrance.daj.service.statement.StatementService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class IntegrationTestConfig {

    @Bean
    StatementService statementService() {
        return new StatementService();
    }
}
