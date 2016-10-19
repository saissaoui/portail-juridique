package fr.artefrance.daj.domain.statement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Objet métier reprensentant un genre artistique: court métrage, musique...
 */
@Entity
@Table(name = "ART_GENRE")
public class ArtGenre {

    @Id
    @Column(name = "genre_code")
    private String genreCode;

    @Column(name = "genre_label")
    private String genreLabel;

    public ArtGenre() {}

    public ArtGenre(String genreCode) {
        this.genreCode = genreCode;
    }

    public String getGenreCode() {
        return genreCode;
    }

    public void setGenreCode(String genreCode) {
        this.genreCode = genreCode;
    }

    public String getGenreLabel() {
        return genreLabel;
    }

    @Override
    public String toString() {
        return "ArtGenre{" +
                "genreCode='" + genreCode + '\'' +
                ", genreLabel='" + genreLabel + '\'' +
                '}';
    }
}
