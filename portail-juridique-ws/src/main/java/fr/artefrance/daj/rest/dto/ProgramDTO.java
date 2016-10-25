package fr.artefrance.daj.rest.dto;


import java.util.Date;

public class ProgramDTO {
    private Long codEmission;
    private String originalTitle;
    private String originalSubTitle;
    private String contractualTitle;
    private String contractualSubTitle;
    private String arteEmNumber;
    private int episodeNumber;
    private String contracting;
    private String status;
    private Date broadcastDate;

    public Long getCodEmission() {
        return codEmission;
    }

    public void setCodEmission(Long codEmission) {
        this.codEmission = codEmission;
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

    public String getArteEmNumber() {
        return arteEmNumber;
    }

    public void setArteEmNumber(String arteEmNumber) {
        this.arteEmNumber = arteEmNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getContracting() {
        return contracting;
    }

    public void setContracting(String contracting) {
        this.contracting = contracting;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBroadcastDate() {
        return broadcastDate;
    }

    public void setBroadcastDate(Date broadcastDate) {
        this.broadcastDate = broadcastDate;
    }
}
