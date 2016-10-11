package fr.artefrance.daj.domain.statement;

public class RecordSupport {
    private String producerName;
    private String supportLabel;
    private String supportNumber;
    private RecodrSupportIdentifier supportIdentifier;

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getSupportLabel() {
        return supportLabel;
    }

    public void setSupportLabel(String supportLabel) {
        this.supportLabel = supportLabel;
    }

    public String getSupportNumber() {
        return supportNumber;
    }

    public void setSupportNumber(String supportNumber) {
        this.supportNumber = supportNumber;
    }

    public RecodrSupportIdentifier getSupportIdentifier() {
        return supportIdentifier;
    }

    public void setSupportIdentifier(RecodrSupportIdentifier supportIdentifier) {
        this.supportIdentifier = supportIdentifier;
    }
}
