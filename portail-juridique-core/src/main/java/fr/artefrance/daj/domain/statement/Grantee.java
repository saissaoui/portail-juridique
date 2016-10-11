package fr.artefrance.daj.domain.statement;


import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Grantee {

    private String firstname;
    private String lastname;
    private List<GranteeRole> roles;

    public Grantee(String firstname, String lastname, List<GranteeRole> roles) {
        Objects.requireNonNull(firstname, "Grantee.firstname is required!");
        Objects.requireNonNull(lastname, "Grantee.lastname is required!");
        Objects.requireNonNull(roles, "Grantee.roles is required!");
        Assert.notEmpty(roles, "Grantes.roles should not be empty!");

        this.firstname = firstname;
        this.lastname = lastname;
        this.roles = roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<GranteeRole> getRoles() {
        return roles;
    }

}
