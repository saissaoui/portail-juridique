package fr.artefrance.daj.domain.statement;


import fr.artefrance.daj.domain.rightholder.RightHolder;
import fr.artefrance.daj.domain.rightholder.RightHolderRole;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(value = "STATEMENT")
public class StatementRightHolder extends RightHolder {

    @Column(name = "partner_id")
    private Long partnerId;

    public StatementRightHolder(String firstname, String lastname, List<RightHolderRole> roles) {
        super(firstname, lastname, roles);
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

}
