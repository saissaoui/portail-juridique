package fr.artefrance.daj.test.domain;


import fr.artefrance.daj.domain.statement.Artwork;
import fr.artefrance.daj.domain.statement.EmissionDTO;
import fr.artefrance.daj.domain.statement.Grantee;
import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.test.factory.ArtworkFactory;
import fr.artefrance.daj.test.factory.GranteeFactory;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static fr.artefrance.daj.domain.statement.StatementStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest {

    private Statement statement;

    @Before
    public void setUp() {
        //GIVEN
        statement = new Statement();
    }

    @Test
    public void statement_can_be_recorded() {
        //GIVEN
        statement.setStatus(PENDING);
        statement.setEmissionDTO(new EmissionDTO());
        statement.setLastActivityDate(LocalDate.now());
        //WHEN
        Boolean valid = statement.canBeRecorded();
        //THEN
        assertThat(valid).isTrue();
    }

    @Test
    public void statement_cannot_be_recorded_without_status() {
        //GIVEN
        statement.setEmissionDTO(new EmissionDTO());
        statement.setLastActivityDate(LocalDate.now());
        //WHEN
        Boolean valid = statement.canBeRecorded();
        //THEN
        assertThat(valid).isFalse();
    }

    @Test
    public void statement_cannot_be_recorded_without_emissiondto() {
        //GIVEN
        statement.setStatus(PENDING);
        statement.setLastActivityDate(LocalDate.now());
        //WHEN
        Boolean valid = statement.canBeRecorded();
        //THEN
        assertThat(valid).isFalse();
    }

    @Test
    public void statement_cannot_be_recorded_without_lastActivityDate() {
        //GIVEN
        statement.setStatus(PENDING);
        statement.setEmissionDTO(new EmissionDTO());
        //WHEN
        Boolean valid = statement.canBeRecorded();
        //THEN
        assertThat(valid).isFalse();
    }

    @Test
    public void statement_can_be_validated_without_artworks() {
        //GIVEN
        statement.setStatus(PENDING);
        statement.setEmissionDTO(new EmissionDTO());
        statement.setLastActivityDate(LocalDate.now());
        statement.setGrantees(GranteeFactory.createTwoGrantee());
        statement.setHasNoArtworks(true);
        statement.setArtworks(null);
        //WHEN
        Boolean valid = statement.canBeValidated();
        //THEN
        assertThat(valid).isTrue();
    }

    @Test
    public void statement_can_be_validated_with_artworks() {
        //GIVEN
        statement.setStatus(PENDING);
        statement.setEmissionDTO(new EmissionDTO());
        statement.setLastActivityDate(LocalDate.now());
        statement.setGrantees(GranteeFactory.createTwoGrantee());
        statement.setHasNoArtworks(false);
        statement.setArtworks(Arrays.asList(ArtworkFactory.createArtwork()));
        //WHEN
        Boolean valid = statement.canBeValidated();
        //THEN
        assertThat(valid).isTrue();
    }

    @Test
    public void statement_cannot_be_validated_without_a_minimum_of_two_grantees() {
        //GIVEN
        statement.setStatus(PENDING);
        statement.setEmissionDTO(new EmissionDTO());
        statement.setLastActivityDate(LocalDate.now());
        statement.setGrantees(Arrays.asList(GranteeFactory.createGrantee()));
        statement.setHasNoArtworks(false);
        statement.setArtworks(Arrays.asList(ArtworkFactory.createArtwork()));
        //WHEN
        Boolean valid = statement.canBeValidated();
        //THEN
        assertThat(valid).isFalse();
    }

    @Test
    public void statement_cannot_be_validated_without_artworks_if_hasnoartworks_unchecked() {
        //GIVEN
        statement.setStatus(PENDING);
        statement.setEmissionDTO(new EmissionDTO());
        statement.setLastActivityDate(LocalDate.now());
        statement.setGrantees(GranteeFactory.createTwoGrantee());
        statement.setHasNoArtworks(false);
        //WHEN
        Boolean valid = statement.canBeValidated();
        //THEN
        assertThat(valid).isFalse();
    }

}
