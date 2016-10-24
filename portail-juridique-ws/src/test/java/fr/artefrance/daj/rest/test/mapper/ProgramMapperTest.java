package fr.artefrance.daj.rest.test.mapper;


import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.rest.dto.ProgramDTO;
import fr.artefrance.daj.rest.mapper.ProgramMapper;
import fr.artefrance.daj.rest.test.factory.ProgramDTOFactory;
import fr.artefrance.daj.rest.test.factory.ProgramFactory;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramMapperTest {

    @Test
    public void emissionDTO_mapping_should_return_a_program() {
        //GIVEN
        ProgramDTO programDTO = ProgramDTOFactory.createProgramDTO();
        Program expected = ProgramFactory.createProgram();

        //WHEN
        Program program = ProgramMapper.INSTANCE.convertToProgram(programDTO);

        //THEN
        assertThat(program).isEqualToComparingFieldByField(expected);
    }
}
