package fr.artefrance.daj.integrationTest;

import fr.artefrance.daj.domain.statement.GranteeRole;
import fr.artefrance.daj.integrationTest.config.IntegrationTestConfig;
import fr.artefrance.daj.repository.statement.GranteeRoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IntegrationTestConfig.class})
public class StatementIntegrationTest {

    @Autowired
    private GranteeRoleRepository grateeRepository;

    @Test
    public void testme() {

        List<GranteeRole> roles = grateeRepository.findAll();
        roles.forEach(System.out::println);
        assertThat(roles).isNotEmpty();

    }

}
