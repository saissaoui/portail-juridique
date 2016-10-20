package fr.artefrance.daj.ws.integrationTest;


import fr.artefrance.daj.domain.security.User;
import fr.artefrance.daj.domain.statement.Program;
import fr.artefrance.daj.ws.integrationTest.config.IntegrationTestConfig;
import fr.artefrance.daj.ws.integrationTest.rest.client.ProgramRestServiceFake;
import fr.artefrance.daj.ws.test.factory.ProgramFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {IntegrationTestConfig.class})
@SpringBootTest
public class ProgramRestServiceTest {

    private static String SOPHIA_WS_PRODUCER_PROGRAMS_SERVICE = "http://localhost:8080/right_program_ws";
    private static String ANOTHER_WRONG_WS_SERVICE = "http://localhost:8080/another_wrong_ws_service";
    private User user;

    @Autowired
    ProgramRestServiceFake programRestServiceFake;

    @Before
    public void setUp() {
        programRestServiceFake.setData(ProgramFactory.createSomeProgram(5));
        user = new User();
    }

    @Test
    public void call_ws_with_right_resource_url() throws IOException {
        programRestServiceFake.setUrl(SOPHIA_WS_PRODUCER_PROGRAMS_SERVICE);
        List<Program> programs = programRestServiceFake.getProducerProgramsFromSophia(user);
        assertThat(programs).isNotNull();
    }

    @Test(expected = IOException.class)
    public void call_ws_with_wrong_resource_url() throws IOException {
        programRestServiceFake.setUrl(ANOTHER_WRONG_WS_SERVICE);
        List<Program> programs = programRestServiceFake.getProducerProgramsFromSophia(user);
        assertThat(programs).isNotNull();
    }
}
