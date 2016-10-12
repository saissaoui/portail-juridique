package fr.artefrance.daj.domain.rightholder;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "RIGHT_HOLDER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public abstract class RightHolder {

    @Id
    @Column(name = "right_holder_id")
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    @ManyToMany
    @JoinTable(name = "RIGHT_HOLDER_HOLDER_ROLE", joinColumns = {@JoinColumn(name = "right_holder_id")}, inverseJoinColumns = {@JoinColumn(name = "role_code")})
    private List<RightHolderRole> roles;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RightHolderType type;

    public RightHolder(String firstname, String lastname, List<RightHolderRole> roles) {
        Objects.requireNonNull(firstname, "RightHolder.firstname is required!");
        Objects.requireNonNull(lastname, "RightHolder.lastname is required!");
        Objects.requireNonNull(roles, "RightHolder.roles is required!");
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

    public RightHolderType getType() {
        return type;
    }

    public void setType(RightHolderType type) {
        this.type = type;
    }
}
