package fr.artefrance.daj.rest.test.factory;


import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementStatus;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StatementFactory {

    private static Statement createStatementWithNoArtworks(int index) {

        Statement statement = new Statement();

        statement.setId((long) index);
        statement.setStatus(StatementStatus.PENDING);
        statement.setLastActivityDate(new Date());
        statement.setProgram(ProgramFactory.createProgram());
        statement.setHasNoArtworks(true);
        statement.setArtworks(null);
        statement.setProducerOwnerId((long) 100 + index);
        statement.setRightHolders(StatementRightHolderFactory.createSomeStatementRightHolderWithOneRightHolderRole(5));

        return  statement;
    }

    public static Statement createStatement() {
        int index = 1;
        return createStatementWithNoArtworks(index);
    }

    public static List<Statement> createSomeStatement(int number) {
        return IntStream.range(0, number)
                        .mapToObj(StatementFactory::createStatementWithNoArtworks)
                        .collect(toList());
    }
}
