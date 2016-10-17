package fr.artefrance.daj.ws.integrationTest.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatementResourceTest {

    @Test
    public void test() {
        assertThat(1).isEqualTo(1);
    }
}
