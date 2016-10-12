package fr.artefrance.daj.test.factory;

import fr.artefrance.daj.domain.statement.StatementRightHolder;
import fr.artefrance.daj.domain.rightholder.RightHolderRole;

import java.util.Arrays;
import java.util.List;

public class GranteeFactory {

    public static StatementRightHolder createGrantee() {

        return new StatementRightHolder(
                "firstname",
                "lastname",
                Arrays.asList(
                        new RightHolderRole(),
                        new RightHolderRole()
                )
        );
    }

    public static List<StatementRightHolder> createTwoGrantee() {

        return Arrays.asList(createGrantee(), createGrantee());
    }
}
