package fr.artefrance.daj.rest.mapper;


import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.rest.dto.ProgramDTO;

public enum ProgramMapper {
    INSTANCE;

    public Program convertToProgram(ProgramDTO programDTO) {

        Program program = new Program();

        program.setId(programDTO.getCodEmission());
        program.setOriginalTitle(programDTO.getOriginalTitle());
        program.setOriginalSubTitle(programDTO.getOriginalSubTitle());
        program.setContractualTitle(programDTO.getContractualTitle());
        program.setContractualSubTitle(programDTO.getContractualSubTitle());
        program.setProductionYear(2016);
        program.setEpisodeNumber(programDTO.getEpisodeNumber());
        program.setDuration(programDTO.getCodEmission());
        program.setArteEmNumber(programDTO.getArteEmNumber());
        program.setIsan("002-0026-C200");

        return program;
    }
}
