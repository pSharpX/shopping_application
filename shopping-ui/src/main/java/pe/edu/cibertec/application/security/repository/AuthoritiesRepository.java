package pe.edu.cibertec.application.security.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.application.security.domain.Authorities;

/**
 * Created by CHRISTIAN on 10/06/2018.
 */
public interface AuthoritiesRepository  extends CrudRepository<Authorities, String> {
}
