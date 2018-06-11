package pe.edu.cibertec.application.security.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pe.edu.cibertec.application.security.domain.User;

public interface UserRepository extends CrudRepository<User, String> {
	long countByEnabled(boolean isEnabled);
	Optional<User> findByUsername(String username);
	Optional<User> findByUsernameAndPassword(String username, String password);
}
