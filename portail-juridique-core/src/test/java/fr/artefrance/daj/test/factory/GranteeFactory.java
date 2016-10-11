package fr.artefrance.daj.test.factory;

import fr.artefrance.daj.domain.statement.Grantee;
import fr.artefrance.daj.domain.statement.GranteeRole;

import java.util.Arrays;
import java.util.List;

public class GranteeFactory {

    public static Grantee createGrantee() {

        return new Grantee(
                "firstname",
                "lastname",
                Arrays.asList(
                        new GranteeRole(),
                        new GranteeRole()
                )
        );
    }

    public static List<Grantee> createTwoGrantee() {

        return Arrays.asList(createGrantee(), createGrantee());
    }
}
