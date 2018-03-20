package br.gov.caixa.pedes.sistemas.sigde.services;

import br.gov.caixa.pedes.sistemas.sigde.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }

    }

}
