package fr.artefrance.daj.domain.statement.artwork;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.time.LocalTime;


@Entity
@Table(name = "artwork_timecode")
public class ArtworkTimeCode {

    @Id
    @Column(name = "timecode_id")
    private Long id;

    @Column(name="timecode_in")
    private Long timeCodeIn;

    @Column(name="timecode_out")
    private Long timeCodeOut;

    @Column(name="duration")
    private Long duration;

    @Column(name = "artwork_id")
    private Long artworkId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeCodeIn() {
        return timeCodeIn;
    }

    public void setTimeCodeIn(Long timeCodeIn) {
        this.timeCodeIn = timeCodeIn;
    }

    public Long getTimeCodeOut() {
        return timeCodeOut;
    }

    public void setTimeCodeOut(Long timeCodeOut) {
        this.timeCodeOut = timeCodeOut;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(Long artworkId) {
        this.artworkId = artworkId;
    }

    @Override
    public String toString() {
        return "ArtworkTimeCode{" +
                "id=" + id +
                ", timeCodeIn=" + timeCodeIn +
                ", timeCodeOut=" + timeCodeOut +
                ", duration=" + duration +
                ", artworkId=" + artworkId +
                '}';
    }
}
