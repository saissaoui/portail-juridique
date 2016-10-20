package fr.artefrance.daj.ws.test.factory;

import fr.artefrance.daj.domain.statement.Program;
import org.jvnet.hk2.internal.Collector;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ProgramFactory {

    private static Program createProgram(int index) {

        Program program = new Program();
        program.setId((long) index);
        program.setOriginalTitle("TITRE (VO) " + index);
        program.setOriginalSubTitle("SOUS TITRE (VO) " + index);
        program.setContractualTitle("TITRE Contractuel " + index);
        program.setContractualSubTitle("SOUS TITRE Contractuel " + index);
        program.setProductionYear(2016);
        program.setEpisodeNumber(index);
        program.setDuration((long) index);
        program.setArteEmNumber("021458" + index);
        program.setIsan("002-0026-C200");

        return  program;
    }

    public static Program createProgram() {
        int index = 1;
        return createProgram(index);
    }

    public static List<Program> createSomeProgram(int number) {
        return IntStream.range(0, number)
                .mapToObj(ProgramFactory::createProgram)
                .collect(toList());
    }

}
