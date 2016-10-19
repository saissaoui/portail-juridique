package fr.artefrance.daj.domain.statement;


import fr.artefrance.daj.domain.rightholder.RightHolder;
import fr.artefrance.daj.domain.rightholder.RightHolderRole;
import fr.artefrance.daj.domain.rightholder.RightHolderType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue(value = "STATEMENT")
public class StatementRightHolder extends RightHolder {

    @Column(name = "partner_id")
    private Long partnerId;


    public StatementRightHolder() {
        super();
    }

    public StatementRightHolder(String firstname, String lastname, List<RightHolderRole> roles, Long partnerId) {
        super(firstname, lastname, roles, RightHolderType.STATEMENT);
        Objects.requireNonNull(firstname, "StatementRightHolder.partnerId is required!");
        this.partnerId = partnerId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

}
