package fr.artefrance.daj.domain.statement.artwork;

import fr.artefrance.daj.domain.rightholder.RightHolder;
import fr.artefrance.daj.domain.rightholder.RightHolderRole;
import fr.artefrance.daj.domain.rightholder.RightHolderType;
import org.springframework.util.Assert;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

import static fr.artefrance.daj.domain.rightholder.RightHolderType.*;

@Entity
@DiscriminatorValue(value = "ARTWORK")
public class ArtworkRightHolder extends RightHolder {

    public ArtworkRightHolder(String firstname, String lastname, List<RightHolderRole> roles) {
        super(firstname, lastname, roles);
    }
}
