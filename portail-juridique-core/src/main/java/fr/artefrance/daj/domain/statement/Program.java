package fr.artefrance.daj.domain.statement;

import javax.persistence.*;

@Entity
@Table(name = "PROGRAM")
public class Program {

    @Id
    @Column(name = "program_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "original_subtitle")
    private String originalSubTitle;

    @Column(name = "contractual_title")
    private String contractualTitle;

    @Column(name = "contractual_subtitle")
    private String contractualSubTitle;

    @Column(name = "production_year")
    private int productionYear;

    @Column(name = "episode_number")
    private int episodeNumber;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "arte_em_number")
    private String arteEmNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "genre_code", insertable = false, updatable = false)
    private ArtGenre genre;

    @Column(name = "isan")
    private String isan;
    @Transient
    // @OneToOne(mappedBy = "program")
    private Statement statement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalSubTitle() {
        return originalSubTitle;
    }

    public void setOriginalSubTitle(String originalSubTitle) {
        this.originalSubTitle = originalSubTitle;
    }

    public String getContractualTitle() {
        return contractualTitle;
    }

    public void setContractualTitle(String contractualTitle) {
        this.contractualTitle = contractualTitle;
    }

    public String getContractualSubTitle() {
        return contractualSubTitle;
    }

    public void setContractualSubTitle(String contractualSubTitle) {
        this.contractualSubTitle = contractualSubTitle;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getArteEmNumber() {
        return arteEmNumber;
    }

    public void setArteEmNumber(String arteEmNumber) {
        this.arteEmNumber = arteEmNumber;
    }

    public ArtGenre getGenre() {
        return genre;
    }

    public void setGenre(ArtGenre genre) {
        this.genre = genre;
    }

    public String getIsan() {
        return isan;
    }

    public void setIsan(String isan) {
        this.isan = isan;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
