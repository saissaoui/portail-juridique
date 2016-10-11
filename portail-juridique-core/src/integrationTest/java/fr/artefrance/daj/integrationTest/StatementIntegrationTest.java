package fr.artefrance.daj.integrationTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class StatementIntegrationTest {

    @Test
    public void testme() {
        assertThat(2).isEqualTo(2);
    }
}
