package fr.artefrance.daj.domain.statement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "GRANTEE_ROLE")
@Entity
public class GranteeRole {

    @Id
    @Column
    private String roleLabel;

    @Column
    private String roleCode;

    public String getRoleLabel() {
        return roleLabel;
    }

    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return "GranteeRole{" +
                "roleLabel='" + roleLabel + '\'' +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
