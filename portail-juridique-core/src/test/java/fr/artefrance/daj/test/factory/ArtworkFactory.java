package fr.artefrance.daj.test.factory;


import fr.artefrance.daj.domain.statement.artwork.Artwork;
import fr.artefrance.daj.domain.statement.ArtGenre;

public class ArtworkFactory {

    public static Artwork createArtwork() {
        return new Artwork("Oeuvre de test", new ArtGenre("CMF"));
    }

    public static Artwork createInvalidArtwork() {
        return new Artwork(null, new ArtGenre("CMF"));
    }
}
