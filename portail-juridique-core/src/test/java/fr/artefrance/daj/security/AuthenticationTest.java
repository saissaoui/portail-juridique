package fr.artefrance.daj.security;


import fr.artefrance.daj.domain.security.User;
import fr.artefrance.daj.service.security.AuthenticationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationTest {

    @Mock
    private AuthenticationService authenticationService;

    @Test
    public void authenticationSuccess() {

        //GIVEN
        String login = "s-aissaoui";
        String password = "goodpass";
        Mockito.when(authenticationService.authenticate(login, password)).thenReturn(new User());

        //WHEN

        User user = authenticationService.authenticate(login, password);

        //THEN
        assertThat(user).isNotNull();
    }

    @Test
    public void authenticationFailure() {

        //GIVEN
        String login = "s-aissaoui";
        String password = "wrongpass";
        Mockito.when(authenticationService.authenticate(login, password)).thenReturn(null);

        //WHEN

        User user = authenticationService.authenticate(login, password);

        //THEN
        assertThat(user).isNull();
    }
}
