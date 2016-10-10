package fr.artefrance.daj.test.domain.statement;

import java.time.LocalDate;
import java.util.List;

public class Statement {

    private String title;
    private StatementStatus status;
    private EmissionDTO emissionDTO;
    private LocalDate activityDate;
    private List<Grantee> grantees;
    private List<Artwork> artworks;
    private Boolean hasArtworks;

}
