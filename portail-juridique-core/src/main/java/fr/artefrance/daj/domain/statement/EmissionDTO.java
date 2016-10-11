package fr.artefrance.daj.domain.statement;


import java.time.LocalDate;
import java.time.LocalTime;

public class EmissionDTO {

    private String originalTitle;
    private String originalSubTitle;
    private String contractualTitle;
    private String contractualSubTitle;
    private LocalDate productionYear;
    private int episodeNumber;
    private LocalTime duration;
    private String arteEmNumber;
    private ArtworkGenre genre;
    private String isan;

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

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getArteEmNumber() {
        return arteEmNumber;
    }

    public void setArteEmNumber(String arteEmNumber) {
        this.arteEmNumber = arteEmNumber;
    }

    public ArtworkGenre getGenre() {
        return genre;
    }

    public void setGenre(ArtworkGenre genre) {
        this.genre = genre;
    }

    public String getIsan() {
        return isan;
    }

    public void setIsan(String isan) {
        this.isan = isan;
    }
}
