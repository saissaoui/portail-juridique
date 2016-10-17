package fr.artefrance.daj.ws.integrationTest.infrastructure.rest.client;


import fr.artefrance.daj.ws.integrationTest.config.IntegrationTestConfig;
import fr.artefrance.daj.ws.integrationTest.config.infrastructure.rest.client.JerseyClientFake;
import fr.artefrance.daj.ws.test.factory.ProgramDTOFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {IntegrationTestConfig.class})
@SpringBootTest
public class JerseyClientTest {

    @Autowired
    JerseyClientFake jerseyClient;

    private String SOPHIA_WS_URL = "http://localhost:8080";
    private String SOPHIA_WS_PRODUCER_PROGRAMS_SERVICE = "/right_program_ws";
    private String INEXISTANT_WS_SERVICE = "/wrong_program_ws";

    @Test
    public void call_ws_with_right_resource_url() throws IOException {
        jerseyClient.setData(ProgramDTOFactory.createSomeProgramDTO(5));
        String wsReturnValue = jerseyClient.callWebService(SOPHIA_WS_URL, SOPHIA_WS_PRODUCER_PROGRAMS_SERVICE);
        assertThat(wsReturnValue).isNotNull();
    }

    @Test(expected = IOException.class)
    public void call_ws_with_wrong_resource_url() throws IOException {
        jerseyClient.setData(ProgramDTOFactory.createSomeProgramDTO(5));
        String wsReturnValue = jerseyClient.callWebService(SOPHIA_WS_URL, INEXISTANT_WS_SERVICE);
        assertThat(wsReturnValue).isNotNull();
    }
}
