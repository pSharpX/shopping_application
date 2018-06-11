package pe.edu.cibertec.application.security.service.impl;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.application.security.domain.User;
import pe.edu.cibertec.application.security.repository.AuthoritiesRepository;
import pe.edu.cibertec.application.security.repository.UserRepository;
import pe.edu.cibertec.application.security.service.CustomUserDetailsService;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements CustomUserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
    @Autowired
    private AuthoritiesRepository authoritiesRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<User> optionalUser = userRepository.findById(username);
        UserBuilder builder = null;
        if (optionalUser.isPresent()) {
          User user = optionalUser.get();
          builder = org.springframework.security.core.userdetails.User.withUsername(username);
          builder.disabled(!user.isEnabled());
          builder.password(user.getPassword());
          String[] authorities = user.getAuthorities()
        		  .stream()
        		  .map(a -> a.getAuthority()).toArray(String[]::new);

          builder.authorities(authorities);
        } else {
          throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    @Transactional(readOnly = true)
    @Override
    public long countByEnabled(boolean isEnabled) {
        return 0;
    }

    @Transactional(readOnly = true)
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Transactional(readOnly = true)
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsById(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setAuthorities(new HashSet<>(authoritiesRepository.findAll()));
        return userRepository.save(user);
    }
}
