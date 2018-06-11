package pe.edu.cibertec.application.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pe.edu.cibertec.application.security.domain.User;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
public interface CustomUserDetailsService extends UserDetailsService {
    long countByEnabled(boolean isEnabled);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    boolean existsById(String id);
    boolean existsByUsername(String username);
    User save(User user);
}
