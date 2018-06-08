package pe.edu.cibertec.application.security.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.application.security.domain.PersistentLogins;
import pe.edu.cibertec.application.security.repository.CustomPersistentTokenRepository;

import java.util.Date;
import java.util.Optional;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
@Repository
@Qualifier("persistentTokenRepository")
public class PersistentTokenRepositoryImpl implements PersistentTokenRepository {

	@Autowired
	private CustomPersistentTokenRepository persistentTokenRepository;

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		PersistentLogins logins = new PersistentLogins();
		logins.setUsername(token.getUsername());
		logins.setSeries(token.getSeries());
		logins.setToken(token.getTokenValue());
		logins.setLastUsed(token.getDate());
		persistentTokenRepository.save(logins);

	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		Optional<PersistentLogins> optionalLogins = persistentTokenRepository.findById(series);
		if (optionalLogins.isPresent()) {
			PersistentLogins logins = optionalLogins.get();
			logins.setToken(tokenValue);
			logins.setLastUsed(lastUsed);
		}
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		Optional<PersistentLogins> optionalLogins = persistentTokenRepository.findById(seriesId);
		if (optionalLogins.isPresent()) {
			PersistentLogins logins = optionalLogins.get();
			return new PersistentRememberMeToken(logins.getUsername(), logins.getSeries(), logins.getToken(),
					logins.getLastUsed());
		}

		return null;
	}

	@Override
	public void removeUserTokens(String username) {
		persistentTokenRepository.deleteByUsername(username);
	}
}
