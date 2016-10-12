package fr.artefrance.daj.integrationTest.config;

import fr.artefrance.daj.integrationTest.infrastructure.h2.JpaRepositoryTestConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaRepositoryTestConfig.class)
public class IntegrationTestConfig {
}
