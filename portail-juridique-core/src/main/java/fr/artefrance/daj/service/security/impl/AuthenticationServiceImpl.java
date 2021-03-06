package fr.artefrance.daj.service.security.impl;


import fr.artefrance.daj.domain.security.User;
import fr.artefrance.daj.service.security.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public User authenticate(String login, String password) {
        return new User();
    }

    @Override
    public User getCurrentUser() {
        User currentUser = new User();
        currentUser.setId(1L);
        currentUser.setFirstName("firstname");
        currentUser.setLastName("lastname");
        return currentUser;
    }
}
