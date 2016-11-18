package fr.artefrance.daj.domain.statement;

import com.fasterxml.jackson.annotation.JsonView;
import fr.artefrance.daj.domain.View;
import fr.artefrance.daj.domain.statement.artwork.Artwork;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Objet métier reprensentant un relevé de droits d'auteur
 */
@Entity
@Table(name = "statement")
public class Statement {

    @Id
    @Column(name = "statement_id")
    @SequenceGenerator( name = "dajIdSequ", sequenceName = "DAJ_ID_SEQU", allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dajIdSequ")
    @JsonView(View.Summary.class)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    @JsonView(View.Summary.class)
    private StatementStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id")
    @NotNull
    @JsonView(View.Summary.class)
    private Program program;

    @Column(name = "last_activity_date")
    @Temporal(TemporalType.DATE)
    @NotNull
    @JsonView(View.Summary.class)
    private Date lastActivityDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="statement_id")
    @JsonView(View.Details.class)
    private Set<StatementRightHolder> rightHolders;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="statement_id")
    @JsonView(View.Details.class)
    private Set<Artwork> artworks;

    @Column(name = "has_no_artworks")
    @JsonView(View.Details.class)
    private Boolean hasNoArtworks;

    @Column(name = "producer_owner_id")
    @NotNull
    @JsonView(View.Details.class)
    private Long producerOwnerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatementStatus getStatus() {
        return status;
    }

    public void setStatus(StatementStatus status) {
        this.status = status;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Set<StatementRightHolder> getRightHolders() {
        return rightHolders;
    }

    public void setRightHolders(Set<StatementRightHolder> rightHolders) {
        this.rightHolders = rightHolders;
    }

    public Set<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(Set<Artwork> artworks) {
        this.artworks = artworks;
    }

    public Boolean getHasNoArtworks() {
        return hasNoArtworks;
    }

    public void setHasNoArtworks(Boolean hasNoArtworks) {
        this.hasNoArtworks = hasNoArtworks;
    }

    public Long getProducerOwnerId() {
        return producerOwnerId;
    }

    public void setProducerOwnerId(Long producerOwnerId) {
        this.producerOwnerId = producerOwnerId;
    }

    public void addStatementRightHolder(StatementRightHolder rightHolder) {
        rightHolders.add(rightHolder);
        rightHolder.setStatementId(this.id);
    }

    public void removeStatementRightHolder(StatementRightHolder rightHolder) {
        rightHolders.add(rightHolder);
        rightHolder.setStatementId(this.id);
    }

    public void addArtwork(Artwork artwork) {
        artworks.add(artwork);
        artwork.setStatementId(this.id);
    }

    public void removeArtwork(Artwork artwork) {
        artworks.add(artwork);
        artwork.setStatementId(this.id);
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", status=" + status +
                ", program=" + program +
                ", lastActivityDate=" + lastActivityDate +
                ", rightHolders=" + rightHolders +
                ", artworks=" + artworks +
                ", hasNoArtworks=" + hasNoArtworks +
                ", producerOwnerId=" + producerOwnerId +
                '}';
    }
}
