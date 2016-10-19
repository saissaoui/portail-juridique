package fr.artefrance.daj.domain.rightholder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe métier representant le rôle d'un ayant droit
 */
@Entity
@Table(name = "RIGHT_HOLDER_ROLE")
public class RightHolderRole {

    @Id
    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_label")
    private String roleLabel;


    public RightHolderRole() {}

    public RightHolderRole(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleLabel() {
        return roleLabel;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return "RightHolderRole{" +
                "roleLabel='" + roleLabel + '\'' +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
