package fr.artefrance.daj.test.factory;

import fr.artefrance.daj.domain.rightholder.RightHolderRole;
import fr.artefrance.daj.domain.statement.StatementRightHolder;

import java.util.Arrays;
import java.util.List;

public class RightHolderFactory {

    public static StatementRightHolder createStatementRightHolder(Long partnerId) {
        return new StatementRightHolder("samy", "La Famille", Arrays.asList(new RightHolderRole("ACT")), partnerId);
    }
    public static List<StatementRightHolder> createTwoStatementRightholders() {

        return Arrays.asList(createStatementRightHolder(2L), createStatementRightHolder(1L));
    }

}
