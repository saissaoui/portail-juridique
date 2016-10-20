package fr.artefrance.daj.test.factory;

import fr.artefrance.daj.domain.statement.Statement;
import fr.artefrance.daj.domain.statement.StatementStatus;

import java.util.Date;

public class StatementFactory {

    public static Statement createBasicStatement() {
        Statement statement = new Statement();
        statement.setLastActivityDate(new Date());
        statement.setStatus(StatementStatus.PENDING);
        statement.setProducerOwnerId(1L);
        return statement;
    }


}
