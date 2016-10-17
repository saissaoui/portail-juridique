package fr.artefrance.daj.ws.integrationTest.config.infrastructure.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Configuration
public class IntegrationTestDatasourceConfig {

    @Bean(destroyMethod = "shutdown")
    DataSource dataSource() {
        return null;
    }
}
