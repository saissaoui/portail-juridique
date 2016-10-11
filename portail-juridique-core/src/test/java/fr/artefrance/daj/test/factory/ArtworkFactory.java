package fr.artefrance.daj.test.factory;


import fr.artefrance.daj.domain.statement.Artwork;
import fr.artefrance.daj.domain.statement.ArtworkGenre;

public class ArtworkFactory {

    public static Artwork createArtwork() {
        ArtworkGenre genre = new ArtworkGenre();
        return new Artwork("title", genre);
    }
}
