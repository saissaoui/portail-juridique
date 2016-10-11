package fr.artefrance.daj.domain.statement;

import javax.validation.constraints.Pattern;
import java.time.LocalTime;


public class ArtworkTimeCode {

    @Pattern(regexp = "d{2}:d{2}:d{2}")
    private LocalTime timeCodeIn;
    @Pattern(regexp = "d{2}:d{2}:d{2}")
    private LocalTime timeCodeOut;
    @Pattern(regexp = "d{2}:d{2}:d{2}")
    private LocalTime duration;

    public LocalTime getTimeCodeIn() {
        return timeCodeIn;
    }

    public void setTimeCodeIn(LocalTime timeCodeIn) {
        this.timeCodeIn = timeCodeIn;
    }

    public LocalTime getTimeCodeOut() {
        return timeCodeOut;
    }

    public void setTimeCodeOut(LocalTime timeCodeOut) {
        this.timeCodeOut = timeCodeOut;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
