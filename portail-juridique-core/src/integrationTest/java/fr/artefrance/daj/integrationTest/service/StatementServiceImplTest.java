package fr.artefrance.daj.integrationTest.service;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementRightHolder;
import fr.artefrance.daj.domain.statement.StatementStatus;
import fr.artefrance.daj.domain.statement.artwork.Artwork;
import fr.artefrance.daj.infrastructure.database.JpaRepositoryConfig;
import fr.artefrance.daj.integrationTest.config.IntegrationTestConfig;
import fr.artefrance.daj.integrationTest.infrastructure.database.IntegrationTestDatasourceConfig;
import fr.artefrance.daj.repository.statement.ArtGenreRepository;
import fr.artefrance.daj.repository.statement.ProgramRepository;
import fr.artefrance.daj.service.statement.StatementService;
import fr.artefrance.daj.test.factory.ArtworkFactory;
import fr.artefrance.daj.test.factory.ProgramFactory;
import fr.artefrance.daj.test.factory.RightHolderFactory;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IntegrationTestConfig.class, IntegrationTestDatasourceConfig.class,
        JpaRepositoryConfig.class})
public class StatementServiceImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

        statement.setProgram(ProgramFactory.createProgram());
        //WHEN
        statementService.create(statement);

        //THEN
        assertThat(statement.getId()).isNotNull();
        System.out.println(statement);

    }


    @Test
    public void right_holder_can_be_added_to_statement() {
        //GIVEN
        Statement statement = new Statement();
        statement.setLastActivityDate(new Date());
        statement.setStatus(StatementStatus.PENDING);

        statement.setProgram(ProgramFactory.createProgram());
        statementService.create(statement);

        StatementRightHolder rightHolder = RightHolderFactory.createStatementRightHolder(1L);

        //WHEN

        statementService.addRightHolderToStatement(statement.getId(), rightHolder);

        //THEN
        statement = statementService.findOneWithFullDataById(statement.getId());
        assertThat(statement.getRightHolders()).isNotEmpty();
        assertThat(statement.getRightHolders().get(0)).isNotNull();

    }

    @Test
    public void artwork_can_be_added_to_statement() {
        //GIVEN
        Statement statement = new Statement();
        statement.setLastActivityDate(new Date());
        statement.setStatus(StatementStatus.PENDING);

        statement.setProgram(ProgramFactory.createProgram());
        statementService.create(statement);

        Artwork artwork = ArtworkFactory.createArtwork();


        //WHEN

        statementService.addArtworkToStatement(statement.getId(), artwork);

        //THEN
        statement = statementService.findOneWithFullDataById(statement.getId());
        assertThat(statement.getArtworks()).isNotEmpty();
        assertThat(statement.getArtworks().get(0)).isNotNull();

    }

    @Test
    public void artwork_cannot_be_added_to_statement_without_title() throws IllegalArgumentException {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(CoreMatchers.containsString("Artwork.title is required"));

        //GIVEN
        Statement statement = new Statement();
        statement.setLastActivityDate(new Date());
        statement.setStatus(StatementStatus.PENDING);

        statement.setProgram(ProgramFactory.createProgram());
        statementService.create(statement);

        Artwork artwork = ArtworkFactory.createInvalidArtwork();


        //WHEN
        statementService.addArtworkToStatement(statement.getId(), artwork);

    }

    @Test
    public void artwork_status_should_be_validated_if_hasNoArtWork_checked_ad_has_two_rightholders() {
        //GIVEN
        Statement statement = new Statement();
        statement.setLastActivityDate(new Date());
        statement.setStatus(StatementStatus.PENDING);

        statement.setProgram(ProgramFactory.createProgram());
        statement.setRightHolders(RightHolderFactory.createTwoStatementRightholders());
        statement.setHasNoArtworks(true);
        statementService.create(statement);


        //WHEN

        statementService.validateStatement(statement);

        //THEN

        assertThat(statementService.findOneById(statement.getId()).getStatus()).isEqualTo(StatementStatus.VALID);

    }

    @Test
    public void artwork_status_shouldnt_be_validated_if_hasArtWorks_chcked_and_artworks_list_empty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(CoreMatchers.containsString("Statement should contain artworks"));

        //GIVEN
        Statement statement = new Statement();
        statement.setLastActivityDate(new Date());
        statement.setStatus(StatementStatus.PENDING);

        statement.setProgram(ProgramFactory.createProgram());
        statement.setRightHolders(RightHolderFactory.createTwoStatementRightholders());
        statement.setHasNoArtworks(false);

        //WHEN
        statementService.validateStatement(statement);

        //THEN
        assertThat(statement.getStatus()).isEqualTo(StatementStatus.PENDING);

    }

    @Test
    public void artwork_status_shouldnt_be_validated_if_contains_less_than_two_rightholders() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(CoreMatchers.containsString("Statement.rightHolders should contain at less two right " +
                                                                 "holders"));

        //GIVEN
        Statement statement = new Statement();
        statement.setLastActivityDate(new Date());
        statement.setStatus(StatementStatus.PENDING);

        statement.setProgram(ProgramFactory.createProgram());
        statement.setRightHolders(Arrays.asList(RightHolderFactory.createStatementRightHolder(1L)));


        //WHEN
        statementService.validateStatement(statement);

        //THEN
        assertThat(statement.getStatus()).isEqualTo(StatementStatus.PENDING);

    }


}