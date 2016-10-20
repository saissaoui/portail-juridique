package fr.artefrance.daj.ws.infrastructure.liquibase;


import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

    @Autowired
    DataSource dataSource;

    private static final String LIQUIBASE_MASTER_FILE_LOCATION = "classpath:db/changelog/master.xml";

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(LIQUIBASE_MASTER_FILE_LOCATION);
        return liquibase;
    }
}
