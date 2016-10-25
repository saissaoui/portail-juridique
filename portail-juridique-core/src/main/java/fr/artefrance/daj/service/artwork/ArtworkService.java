package fr.artefrance.daj.service.artwork;


import fr.artefrance.daj.domain.statement.artwork.Artwork;

public interface ArtworkService {

    Artwork findArtworkById(Long artworkId);

    Artwork create(Artwork artwork);
}
