package fr.artefrance.daj.domain.statement.artwork;

import javax.persistence.*;

@Entity
@Table(name = "RECORD_SUPPORT")
public class RecordSupport {

    @Id
    @Column(name = "record_support_id")
    private Long id;

    @Column(name = "producer_name")
    private String producerName;

    @Column(name = "support_label")
    private String supportLabel;

    @Column(name = "support_number")
    private String supportNumber;

    @Column(name = "support_identifier")
    @Enumerated(EnumType.STRING)
    private RecordSupportIdentifier supportIdentifier;

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

    public RecordSupportIdentifier getSupportIdentifier() {
        return supportIdentifier;
    }

    public void setSupportIdentifier(RecordSupportIdentifier supportIdentifier) {
        this.supportIdentifier = supportIdentifier;
    }
}