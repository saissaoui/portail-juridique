package fr.artefrance.daj.domain.statement;

import fr.artefrance.daj.domain.statement.artwork.Artwork;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Objet métier reprensentant un relevé de droits d'auteur
 */
@Entity
@Table(name = "STATEMENT")
public class Statement {

    @Id
    @Column(name = "statement_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private StatementStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id")
    private Program program;

    @Column(name = "last_activity_date")
    @Temporal(TemporalType.DATE)
    private Date lastActivityDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "statement_id")
    private List<StatementRightHolder> rightHolders;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "statement_id")
    private List<Artwork> artworks;

    @Column(name = "has_no_artworks")
    private Boolean hasNoArtworks;

    @Column(name = "producer_owner_id")
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

    public List<StatementRightHolder> getRightHolders() {
        return rightHolders;
    }

    public void setRightHolders(List<StatementRightHolder> rightHolders) {
        this.rightHolders = rightHolders;
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

    public Long getProducerOwnerId() {
        return producerOwnerId;
    }

    public void setProducerOwnerId(Long producerOwnerId) {
        this.producerOwnerId = producerOwnerId;
    }

    public Boolean canBeRecorded() {
        return lastActivityDate != null && status != null && program != null;
    }


    public void checkValidation() {
        Assert.isTrue(canBeRecorded(),"Statement cannot be recorded");
        Assert.notEmpty(rightHolders,"Statement.rightHolders cannot be empty");
        Assert.isTrue(rightHolders.size() > 1,"Statement.rightHolders should contain at less two right holders");
        Assert.isTrue(hasNoArtworks || artworks != null && !artworks.isEmpty(),"Statement should contain artworks");
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
