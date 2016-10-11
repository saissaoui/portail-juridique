package fr.artefrance.daj.domain.statement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Statement {

    private String title;
    private StatementStatus status;
    private EmissionDTO emissionDTO;
    private LocalDate lastActivityDate;
    private List<Grantee> grantees;
    private List<Artwork> artworks;
    private Boolean hasNoArtworks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StatementStatus getStatus() {
        return status;
    }

    public void setStatus(StatementStatus status) {
        this.status = status;
    }

    public EmissionDTO getEmissionDTO() {
        return emissionDTO;
    }

    public void setEmissionDTO(EmissionDTO emissionDTO) {
        this.emissionDTO = emissionDTO;
    }

    public LocalDate getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(LocalDate lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public List<Grantee> getGrantees() {
        return grantees;
    }

    public void setGrantees(List<Grantee> grantees) {
        this.grantees = grantees;
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<Artwork> artworks) {
        this.artworks = artworks;
    }

    public Boolean getHasNoArtworks() {
        return hasNoArtworks;
    }

    public void setHasNoArtworks(Boolean hasNoArtworks) {
        this.hasNoArtworks = hasNoArtworks;
    }

    public Boolean canBeRecorded() {
        return lastActivityDate != null && status != null && emissionDTO != null;
    }

    public Boolean canBeValidated() {

        return canBeRecorded() && grantees != null && !grantees.isEmpty() && grantees.size() > 1 && (hasNoArtworks ||
                !hasNoArtworks && artworks != null && !artworks.isEmpty());
    }
}
