package fr.artefrance.daj.domain.statement.artwork;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.time.LocalTime;


@Entity
@Table(name = "ARTWORK_TIMECODE")
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
}
