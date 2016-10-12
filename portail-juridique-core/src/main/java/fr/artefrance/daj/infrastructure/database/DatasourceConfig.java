package fr.artefrance.daj.infrastructure.database;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    DataSource dataSource() {
        return null;
    }
}
