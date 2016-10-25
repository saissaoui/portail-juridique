package fr.artefrance.daj.service.artwork.impl;


import fr.artefrance.daj.domain.statement.artwork.Artwork;
import fr.artefrance.daj.repository.statement.artwork.ArtworkRepository;
import fr.artefrance.daj.service.artwork.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArtworkServiceImpl implements ArtworkService {

    @Autowired
    ArtworkRepository artworkRepository;

    @Override
    public Artwork create(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    @Override
    public Artwork findArtworkById(Long artworkId) {
        return artworkRepository.findOne(artworkId);
    }
}
