package fr.artefrance.daj.domain.statement.artwork;

import fr.artefrance.daj.domain.rightholder.RightHolder;
import fr.artefrance.daj.domain.rightholder.RightHolderRole;
import fr.artefrance.daj.domain.rightholder.RightHolderType;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

import static fr.artefrance.daj.domain.rightholder.RightHolderType.*;

/**
 * Objet métier representant un ayant droit d'une oeuvre
 */
@Entity
@DiscriminatorValue(value = "ARTWORK")
public class ArtworkRightHolder extends RightHolder {

    @Column(name = "artwork_id")
    private Long artworkId;

    public ArtworkRightHolder(String firstname, String lastname, List<RightHolderRole> roles) {
        super(firstname, lastname, roles,RightHolderType.ARTWORK);
    }

    public Long getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(Long artworkId) {
        this.artworkId = artworkId;
    }

    @Override
    public String toString() {
        return "ArtworkRightHolder{" +
                "artworkId=" + artworkId +
                '}';
    }
}
