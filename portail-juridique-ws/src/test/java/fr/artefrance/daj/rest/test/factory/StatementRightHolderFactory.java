package fr.artefrance.daj.rest.test.factory;


import fr.artefrance.daj.domain.rightholder.RightHolderRole;
import fr.artefrance.daj.domain.statement.StatementRightHolder;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StatementRightHolderFactory {

    private static StatementRightHolder createOneStatementRightHolderWithOneRightHolderRole(int index) {

        String firstname = "rightHolder_firstname_" + index;
        String lastname = "rightHolder_lastname_" + index;
        Long partner_id = (long)index;
        List< RightHolderRole > roles = RightHolderRoleFactory.oneRightHolderRole();

        return new StatementRightHolder(firstname, lastname, roles, partner_id);
    }

    public static StatementRightHolder createOneStatementRightHolderWithSomeRightHolderRole(int index) {

        String firstname = "rightHolder_firstname_" + index;
        String lastname = "rightHolder_lastname_" + index;
        Long partner_id = (long)index;
        List< RightHolderRole > roles = RightHolderRoleFactory.someRightHolderRole();

        return new StatementRightHolder(firstname, lastname, roles, partner_id);
    }

    private static StatementRightHolder createOneStatementRightHolderWithOneRightHolderRole() {
        int index = 1;
        return createOneStatementRightHolderWithOneRightHolderRole(index);
    }

    public static Set<StatementRightHolder> createSomeStatementRightHolderWithOneRightHolderRole(int number) {
        return IntStream.range(0, number)
                        .mapToObj(StatementRightHolderFactory::createOneStatementRightHolderWithOneRightHolderRole)
                        .collect(toSet());
    }
}
