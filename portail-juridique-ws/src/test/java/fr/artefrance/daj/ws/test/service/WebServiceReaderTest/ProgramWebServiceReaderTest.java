package fr.artefrance.daj.ws.test.service.WebServiceReaderTest;


import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.ws.service.WebServiceReader.impl.ProgramWebServiceReader;
import fr.artefrance.daj.ws.test.factory.ProgramFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramWebServiceReaderTest {

    @Test
    public void web_service_return_string_value_should_return_a_program() throws IOException {

        //GIVEN
        List<Program> expected = Collections.singletonList(ProgramFactory.createProgram());
        ProgramWebServiceReader webServiceReader = new ProgramWebServiceReader();
        String wsReturnStringValue = "[" +
                "{" +
                "\"id\":1," +
                "\"originalTitle\":\"TITRE (VO) 1\"," +
                "\"originalSubTitle\":\"SOUS TITRE (VO) 1\"," +
                "\"contractualTitle\":\"TITRE Contractuel 1\"," +
                "\"contractualSubTitle\":\"SOUS TITRE Contractuel 1\"," +
                "\"productionYear\":2016," +
                "\"episodeNumber\":1," +
                "\"duration\":1," +
                "\"arteEmNumber\":\"0214581\"," +
                "\"genre\":null," +
                "\"isan\":\"002-0026-C200\"," +
                "\"statement\":null" +
                "}" +
                "]";

        //WHEN
        List<Program> actual = webServiceReader.read(wsReturnStringValue);

        //THEN
        assertThat(actual).usingRecursiveFieldByFieldElementComparator().isEqualTo(expected);

    }
}
