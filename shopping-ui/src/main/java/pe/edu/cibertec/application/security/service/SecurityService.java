package pe.edu.cibertec.application.security.service;

/**
 * Created by CHRISTIAN on 10/06/2018.
 */
public interface SecurityService {
    String findLoggedInUsername();
    void autologin(String username, String password);
}
