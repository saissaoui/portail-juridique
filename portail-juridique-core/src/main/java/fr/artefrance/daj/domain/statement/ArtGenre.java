package fr.artefrance.daj.domain.statement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ART_GENRE")
public class ArtGenre {

    @Id
    @Column(name = "genre_code")
    private String genreCode;

    @Column(name = "genre_label")
    private String genreLabel;

    public String getGenreCode() {
        return genreCode;
    }

    public void setGenreCode(String genreCode) {
        this.genreCode = genreCode;
    }

    public String getGenreLabel() {
        return genreLabel;
    }

    public void setGenreLabel(String genreLabel) {
        this.genreLabel = genreLabel;
    }

    @Override
    public String toString() {
        return "ArtGenre{" +
                "genreCode='" + genreCode + '\'' +
                ", genreLabel='" + genreLabel + '\'' +
                '}';
    }
}
