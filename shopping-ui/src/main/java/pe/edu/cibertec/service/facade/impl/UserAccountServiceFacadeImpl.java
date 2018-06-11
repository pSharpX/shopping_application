package pe.edu.cibertec.service.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.cibertec.application.annotation.BusinessService;
import pe.edu.cibertec.application.security.domain.User;
import pe.edu.cibertec.application.security.service.CustomUserDetailsService;
import pe.edu.cibertec.application.security.service.PersistentTokenService;
import pe.edu.cibertec.service.facade.UserAccountServiceFacade;

import javax.validation.constraints.NotNull;

/**
 * Created by CHRISTIAN on 10/06/2018.
 */
@BusinessService
public class UserAccountServiceFacadeImpl implements UserAccountServiceFacade {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private PersistentTokenService persistentTokenService;

    @Override
    public void createNewAccount(@NotNull User user) {
        customUserDetailsService.save(user);
    }

    @Override
    public boolean existsUserAccount(@NotNull String username) {
        return customUserDetailsService.existsByUsername(username);
    }
}
