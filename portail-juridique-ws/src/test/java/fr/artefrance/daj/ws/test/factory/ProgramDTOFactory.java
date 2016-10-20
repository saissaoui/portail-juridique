package fr.artefrance.daj.ws.test.factory;


import fr.artefrance.daj.ws.rest.dto.ProgramDTO;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ProgramDTOFactory {

    private static ProgramDTO createProgramDTO(int index) {

        ProgramDTO programDTO = new ProgramDTO();
        programDTO.setCodEmission((long) index);
        programDTO.setOriginalTitle("TITRE (VO) " + index);
        programDTO.setOriginalSubTitle("SOUS TITRE (VO) " + index);
        programDTO.setContractualTitle("TITRE Contractuel " + index);
        programDTO.setContractualSubTitle("SOUS TITRE Contractuel " + index);
        programDTO.setArteEmNumber("021458" + index);
        programDTO.setEpisodeNumber(index);
        programDTO.setContracting("Sombrero & Co");
        programDTO.setStatus("Envoyé");
        programDTO.setBroadcastDate(new Date());

        return programDTO;
    }

    public static ProgramDTO createProgramDTO() {
        int index = 1;
        return createProgramDTO(index);
    }

    public static List<ProgramDTO> createSomeProgramDTO(int number) {
        return IntStream.range(0, number)
                        .mapToObj(ProgramDTOFactory::createProgramDTO)
                        .collect(toList());
    }
}
