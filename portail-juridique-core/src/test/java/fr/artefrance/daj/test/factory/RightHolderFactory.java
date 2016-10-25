package fr.artefrance.daj.test.factory;

import fr.artefrance.daj.domain.rightholder.RightHolderRole;
import fr.artefrance.daj.domain.statement.StatementRightHolder;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class RightHolderFactory {

    public static StatementRightHolder createStatementRightHolder(Long partnerId) {
        return new StatementRightHolder("samy", "La Famille", Arrays.asList(new RightHolderRole("ACT")), partnerId);
    }
    public static Set<StatementRightHolder> createTwoStatementRightholders() {
        Set<StatementRightHolder> statementRightHolders = new LinkedHashSet<>();

        statementRightHolders.add(createStatementRightHolder(1L));
        statementRightHolders.add(createStatementRightHolder(2L));
        
        return statementRightHolders;
    }

}
