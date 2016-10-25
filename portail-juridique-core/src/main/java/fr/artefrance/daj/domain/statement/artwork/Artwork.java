package fr.artefrance.daj.domain.statement.artwork;


import fr.artefrance.daj.domain.statement.ArtGenre;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Set;

/**
 * Objet métier representant une Oeuvre
 */
@Entity
@Table(name = "artwork")
public class Artwork {

    @Id
    @Column(name = "artwork_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "genre_code")
    private ArtGenre genre;

    @Column(name = "music_type")
    @Enumerated(EnumType.STRING)
    private ArtworkMusicType musicType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "artwork_id")
    private Set<ArtworkTimeCode> timeCodes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "artwork_id")
    private Set<ArtworkRightHolder> rightHolders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_support_id")
    private RecordSupport recordSupport;

    @Column(name = "statement_id")
    private Long statementId;

    public Artwork() {
    }

    public Artwork(String title, ArtGenre genre) {
        Assert.notNull(title, "Artwork.title is required");
        Assert.notNull(genre, "Artwork.genre is required");
        this.title = title;
        this.genre = genre;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public ArtGenre getGenre() {
        return genre;
    }

    public ArtworkMusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(ArtworkMusicType musicType) {
        this.musicType = musicType;
    }

    public Set<ArtworkTimeCode> getTimeCodes() {
        return timeCodes;
    }

    public void setTimeCodes(Set<ArtworkTimeCode> timeCodes) {
        this.timeCodes = timeCodes;
    }

    public Set<ArtworkRightHolder> getRightHolders() {
        return rightHolders;
    }

    public void setRightHolders(Set<ArtworkRightHolder> rightHolders) {
        this.rightHolders = rightHolders;
    }

    public RecordSupport getRecordSupport() {
        return recordSupport;
    }

    public void setRecordSupport(RecordSupport recordSupport) {
        this.recordSupport = recordSupport;
    }

    public Long getStatementId() {
        return statementId;
    }

    public void setStatementId(Long statementId) {
        this.statementId = statementId;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", musicType=" + musicType +
                ", timeCodes=" + timeCodes +
                ", rightHolders=" + rightHolders +
                ", recordSupport=" + recordSupport +
                ", statementId=" + statementId +
                '}';
    }
}
