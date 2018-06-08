package pe.edu.cibertec.application.security.repository.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
@Repository
@Qualifier("persistentTokenRepository")
public class PersistentTokenRepositoryImpl implements PersistentTokenRepository {
    @Override
    public void createNewToken(PersistentRememberMeToken token) {

    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {

    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        return null;
    }

    @Override
    public void removeUserTokens(String username) {

    }
}
