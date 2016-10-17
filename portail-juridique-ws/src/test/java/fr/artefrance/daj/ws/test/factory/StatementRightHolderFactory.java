package fr.artefrance.daj.ws.test.factory;


import fr.artefrance.daj.domain.rightholder.RightHolderRole;
import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.domain.statement.StatementRightHolder;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StatementRightHolderFactory {

    private static StatementRightHolder createOneStatementRightHolderWithOneRightHolderRole(int index) {

        String firstname = "rightHolder_firstname_" + index;
        String lastname = "rightHolder_lastname_" + index;
        List< RightHolderRole > roles = RightHolderRoleFactory.oneRightHolderRole();

        return new StatementRightHolder(firstname, lastname, roles);
    }

    public static StatementRightHolder createOneStatementRightHolderWithSomeRightHolderRole(int index) {

        String firstname = "rightHolder_firstname_" + index;
        String lastname = "rightHolder_lastname_" + index;
        List< RightHolderRole > roles = RightHolderRoleFactory.someRightHolderRole();

        return new StatementRightHolder(firstname, lastname, roles);
    }

    private static StatementRightHolder createOneStatementRightHolderWithOneRightHolderRole() {
        int index = 1;
        return createOneStatementRightHolderWithOneRightHolderRole(index);
    }

    public static List<StatementRightHolder> createSomeStatementRightHolderWithOneRightHolderRole(int number) {
        return IntStream.range(0, number)
                        .mapToObj(StatementRightHolderFactory::createOneStatementRightHolderWithOneRightHolderRole)
                        .collect(toList());
    }
}
