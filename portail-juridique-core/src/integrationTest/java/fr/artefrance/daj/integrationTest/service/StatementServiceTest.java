package fr.artefrance.daj.integrationTest.service;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementStatus;
import fr.artefrance.daj.infrastructure.database.JpaRepositoryConfig;
import fr.artefrance.daj.integrationTest.config.IntegrationTestConfig;
import fr.artefrance.daj.integrationTest.infrastructure.database.IntegrationTestDatasourceConfig;
import fr.artefrance.daj.repository.statement.ArtGenreRepository;
import fr.artefrance.daj.repository.statement.ProgramRepository;
import fr.artefrance.daj.service.statement.StatementService;
import fr.artefrance.daj.test.factory.ProgramFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IntegrationTestConfig.class, IntegrationTestDatasourceConfig.class,
        JpaRepositoryConfig.class})
public class StatementServiceTest {

    @Autowired
    StatementService statementService;
    @Autowired
    ProgramRepository programRepository;

    @Autowired
    ArtGenreRepository artGenreRepository;

    @Test
    public void statement_should_have_id_when_created() {
        //GIVEN
        Statement statement = new Statement();
        statement.setLastActivityDate(new Date());
        statement.setStatus(StatementStatus.PENDING);

//        Program program = new Program();
        //program.setStatement(statement);
       // programRepository.save(program);
        statement.setProgram(ProgramFactory.createProgram());
        System.out.println("BEFORE###################################################################");
        artGenreRepository.findAll().forEach(System.out::println);

        //WHEN
        statementService.create(statement);

        //THEN
        assertThat(statement.getId()).isNotNull();
        System.out.println(statement);
        System.out.println("AFTER##################################################################");
        artGenreRepository.findAll().forEach(System.out::println);

    }


}
