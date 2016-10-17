package fr.artefrance.daj.integrationTest.config;

import fr.artefrance.daj.service.statement.StatementService;
import fr.artefrance.daj.service.statement.impl.StatementServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegrationTestConfig {

    @Bean
    StatementService statementService() {
        return new StatementServiceImpl();
    }
}
