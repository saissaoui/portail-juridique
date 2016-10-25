package fr.artefrance.daj.service.security;

import fr.artefrance.daj.domain.security.User;

public interface AuthenticationService {
    User authenticate(String login, String password);

    User getCurrentUser();
}
