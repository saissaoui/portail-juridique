package fr.artefrance.daj.ws.integrationTest.rest;


import fr.artefrance.daj.ws.integrationTest.config.IntegrationTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {IntegrationTestConfig.class})
@SpringBootTest
public class StatementResourceTest {

    @Test
    public void test() {
        assertThat(1).isEqualTo(1);
    }
}
