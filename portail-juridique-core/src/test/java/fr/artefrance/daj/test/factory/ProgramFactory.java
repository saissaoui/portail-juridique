package fr.artefrance.daj.test.factory;


import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.domain.statement.ArtGenre;

public class ProgramFactory {

    public static Program createProgram(ArtGenre genre) {

        Program program = new Program();
        program.setOriginalTitle("TITRE (VO)");
        program.setOriginalSubTitle("SOUS TITRE (VO)");
        program.setContractualTitle("TITRE Contractuel");
        program.setContractualSubTitle("SOUS TITRE Contractuel");
        program.setProductionYear(2016);
        program.setEpisodeNumber(1);
        program.setDuration(90L);
        program.setGenre(genre);
        program.setArteEmNumber("021458");
        program.setArteEmNumber("002-0026-f0f0f");

        return  program;
    }

    public static Program createProgram() {

        ArtGenre genre = new ArtGenre("CMF");

        return createProgram(genre);
    }
}
