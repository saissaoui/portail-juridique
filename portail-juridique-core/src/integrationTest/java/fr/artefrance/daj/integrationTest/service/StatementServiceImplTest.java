package fr.artefrance.daj.integrationTest.service;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementRightHolder;
import fr.artefrance.daj.domain.statement.StatementStatus;
import fr.artefrance.daj.domain.statement.artwork.Artwork;
import fr.artefrance.daj.integrationTest.config.IntegrationTestConfig;
import fr.artefrance.daj.integrationTest.config.IntegrationTestDatasourceConfig;
import fr.artefrance.daj.repository.config.JpaRepositoryConfig;
import fr.artefrance.daj.repository.statement.ArtGenreRepository;
import fr.artefrance.daj.repository.statement.ProgramRepository;
import fr.artefrance.daj.service.statement.StatementService;
import fr.artefrance.daj.test.factory.ArtworkFactory;
import fr.artefrance.daj.test.factory.ProgramFactory;
import fr.artefrance.daj.test.factory.RightHolderFactory;
import fr.artefrance.daj.test.factory.StatementFactory;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

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
        Statement statement = StatementFactory.createBasicStatement();

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
        Statement statement = StatementFactory.createBasicStatement();

        statement.setProgram(ProgramFactory.createProgram());
        statementService.create(statement);

        StatementRightHolder rightHolder = RightHolderFactory.createStatementRightHolder(1L);

        //WHEN
        statementService.addRightHolderToStatement(statement.getId(), rightHolder);

        //THEN
        statement = statementService.findStatementById(statement.getId());
        Set<StatementRightHolder> rightHolders = new LinkedHashSet<>(statement.getRightHolders());
        assertThat(rightHolders).isNotEmpty();
        assertThat(rightHolders.iterator().next()).isNotNull();

    }

    @Test
    public void artwork_can_be_added_to_statement() {
        //GIVEN
        Statement statement = StatementFactory.createBasicStatement();

        statement.setProgram(ProgramFactory.createProgram());
        statementService.create(statement);

        Artwork artwork = ArtworkFactory.createArtwork();


        //WHEN
        statementService.addArtworkToStatement(statement.getId(), artwork);

        //THEN
        statement = statementService.findStatementById(statement.getId());
        HashSet<Artwork> artworks = new HashSet<>(statement.getArtworks());
        assertThat(artworks).isNotEmpty();
        assertThat(artworks.iterator().next()).isNotNull();

    }

    @Test
    public void artwork_cannot_be_added_to_statement_without_title() throws IllegalArgumentException {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(CoreMatchers.containsString("Artwork.title is required"));

        //GIVEN
        Statement statement = StatementFactory.createBasicStatement();

        statement.setProgram(ProgramFactory.createProgram());
        statementService.create(statement);

        Artwork artwork = ArtworkFactory.createInvalidArtwork();


        //WHEN
        statementService.addArtworkToStatement(statement.getId(), artwork);

    }

    @Test
    public void artwork_status_should_be_validated_if_hasNoArtWork_checked_ad_has_two_rightholders() {
        //GIVEN
        Statement statement = StatementFactory.createBasicStatement();

        statement.setProgram(ProgramFactory.createProgram());
        statement.setRightHolders(RightHolderFactory.createTwoStatementRightholders());
        statement.setHasNoArtworks(true);
        statementService.create(statement);


        //WHEN

        statementService.validateStatement(statement);

        //THEN

        assertThat(statementService.findStatementById(statement.getId()).getStatus()).isEqualTo(StatementStatus.VALID);

    }

    @Test
    public void artwork_status_shouldnt_be_validated_if_hasArtWorks_chcked_and_artworks_list_empty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(CoreMatchers.containsString("Statement should contain artworks"));

        //GIVEN
        Statement statement = StatementFactory.createBasicStatement();

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
        Statement statement = StatementFactory.createBasicStatement();

        statement.setProgram(ProgramFactory.createProgram());
        Set<StatementRightHolder> rightHolders = new LinkedHashSet<>();
        rightHolders.add(RightHolderFactory.createStatementRightHolder(1L));
        statement.setRightHolders(rightHolders);

        //WHEN
        statementService.validateStatement(statement);

        //THEN
        assertThat(statement.getStatus()).isEqualTo(StatementStatus.PENDING);

    }

    @Test
    public void all_statements_should_be_valid_when_archived_st_are_retrieved() {

        //GIVEN
        Long producerId = 1L;

        //WHEN

        List<Statement> archived = statementService.findArchivedStatementsByProducerId(producerId);

        //THEN

        assertThat(archived).isNotEmpty();
        assertThat(archived).allMatch(statement -> statement.getStatus().equals(StatementStatus.VALID));

    }
}
