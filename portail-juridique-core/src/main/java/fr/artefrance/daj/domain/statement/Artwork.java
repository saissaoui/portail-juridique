package fr.artefrance.daj.domain.statement;


import java.util.List;
import java.util.Objects;

public class Artwork {

    private String title;
    private ArtworkGenre genre;
    private ArtworkMusicType musicType;
    private List<ArtworkTimeCode> timeCodes;
    private List<Grantee> grantees;
    private RecordSupport recordSupport;

    public Artwork(String title, ArtworkGenre genre ) {
        Objects.requireNonNull(title, "Artwork.title is required");
        Objects.requireNonNull(genre, "Artwork.genre is required");
        this.title = title;
        this.genre = genre;

    }

    public String getTitle() {
        return title;
    }

    public ArtworkGenre getGenre() {
        return genre;
    }

    public ArtworkMusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(ArtworkMusicType musicType) {
        this.musicType = musicType;
    }

    public List<ArtworkTimeCode> getTimeCodes() {
        return timeCodes;
    }

    public void setTimeCodes(List<ArtworkTimeCode> timeCodes) {
        this.timeCodes = timeCodes;
    }

    public List<Grantee> getGrantees() {
        return grantees;
    }

    public void setGrantees(List<Grantee> grantees) {
        this.grantees = grantees;
    }

    public RecordSupport getRecordSupport() {
        return recordSupport;
    }

    public void setRecordSupport(RecordSupport recordSupport) {
        this.recordSupport = recordSupport;
    }
}
