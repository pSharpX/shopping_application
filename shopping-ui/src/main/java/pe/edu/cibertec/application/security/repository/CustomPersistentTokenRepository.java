package pe.edu.cibertec.application.security.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.cibertec.application.security.domain.PersistentLogins;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
public interface CustomPersistentTokenRepository extends CrudRepository<PersistentLogins, String> {
	Iterable<PersistentLogins> findByUsername(String username);
	void deleteByUsername(String username);
}
