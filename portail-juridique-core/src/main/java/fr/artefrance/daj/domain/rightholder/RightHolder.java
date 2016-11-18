package fr.artefrance.daj.domain.rightholder;

import com.fasterxml.jackson.annotation.JsonView;
import fr.artefrance.daj.domain.View;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Objet métier representant un ayant droit.
 * Classe abstraite heritée par {@link fr.artefrance.daj.domain.statement.StatementRightHolder} et {@link fr.artefrance.daj.domain.statement.artwork.ArtworkRightHolder}
 */
@Entity
@Table(name = "right_holder")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class RightHolder {

    @Id
    @Column(name = "right_holder_id")
    @SequenceGenerator( name = "dajIdSequ", sequenceName = "DAJ_ID_SEQU", allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dajIdSequ")
    @JsonView(View.Details.class)
    private Long id;

    @Column
    @JsonView(View.Details.class)
    private String firstname;

    @Column
    @JsonView(View.Details.class)
    private String lastname;

    @JsonView(View.AdvancedDetails.class)
    @ManyToMany
    @JoinTable(name = "right_holder_holder_role", joinColumns = {@JoinColumn(name = "right_holder_id")}, inverseJoinColumns = {@JoinColumn(name = "role_code")})
    private List<RightHolderRole> roles;

    public RightHolder() {
    }

    public RightHolder(String firstname, String lastname, List<RightHolderRole> roles, RightHolderType type) {
        Objects.requireNonNull(firstname, "RightHolder.firstname is required!");
        Objects.requireNonNull(lastname, "RightHolder.lastname is required!");
        Objects.requireNonNull(roles, "RightHolder.roles is required!");
        Objects.requireNonNull(type, "RightHolder.type is required!");
        Assert.notEmpty(roles, "RightHolder.roles should not be empty!");

        this.firstname = firstname;
        this.lastname = lastname;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<RightHolderRole> getRoles() {
        return roles;
    }

    public void setRoles(List<RightHolderRole> roles) {
        this.roles = roles;
    }

}
