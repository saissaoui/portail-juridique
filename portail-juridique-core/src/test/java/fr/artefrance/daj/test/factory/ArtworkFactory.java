package fr.artefrance.daj.test.factory;


import fr.artefrance.daj.domain.statement.artwork.Artwork;
import fr.artefrance.daj.domain.statement.ArtGenre;

public class ArtworkFactory {

    public static Artwork createArtwork() {
        ArtGenre genre = new ArtGenre();
        return new Artwork("title", genre);
    }
}
