package pe.edu.cibertec.service.facade;

import pe.edu.cibertec.application.security.domain.User;

/**
 * Created by CHRISTIAN on 10/06/2018.
 */
public interface UserAccountServiceFacade {
    void createNewAccount(User user);
    boolean existsUserAccount(String username);
}
