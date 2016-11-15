package fr.artefrance.daj.domain.statement;

import com.fasterxml.jackson.annotation.JsonView;
import fr.artefrance.daj.domain.View;

import javax.persistence.*;

@Entity
@Table(name = "program")
public class Program {

    @Id
    @Column(name = "program_id")
    @SequenceGenerator(name = "dajIdSequ", sequenceName = "DAJ_ID_SEQU", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dajIdSequ")
    @JsonView(View.Summary.class)
    private Long id;

    @Column(name = "original_title")
    @JsonView(View.Summary.class)
    private String originalTitle;

    @Column(name = "original_subtitle")
    @JsonView(View.Summary.class)
    private String originalSubTitle;

    @Column(name = "contractual_title")
    @JsonView(View.Summary.class)
    private String contractualTitle;

    @Column(name = "contractual_subtitle")
    @JsonView(View.Summary.class)
    private String contractualSubTitle;

    @Column(name = "production_year")
    @JsonView(View.Summary.class)
    private int productionYear;

    @Column(name = "episode_number")
    @JsonView(View.Summary.class)
    private int episodeNumber;

    @Column(name = "duration")
    @JsonView(View.Summary.class)
    private Long duration;

    @Column(name = "arte_em_number")
    @JsonView(View.Summary.class)
    private String arteEmNumber;

    @ManyToOne
    @JoinColumn(name = "genre_code")
    private ArtGenre genre;

    @Column(name = "isan")
    @JsonView(View.Summary.class)
    private String isan;

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

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", originalTitle='" + originalTitle + '\'' +
                ", originalSubTitle='" + originalSubTitle + '\'' +
                ", contractualTitle='" + contractualTitle + '\'' +
                ", contractualSubTitle='" + contractualSubTitle + '\'' +
                ", productionYear=" + productionYear +
                ", episodeNumber=" + episodeNumber +
                ", duration=" + duration +
                ", arteEmNumber='" + arteEmNumber + '\'' +
                ", genre=" + genre +
                ", isan='" + isan + '\'' +
                '}';
    }
}
