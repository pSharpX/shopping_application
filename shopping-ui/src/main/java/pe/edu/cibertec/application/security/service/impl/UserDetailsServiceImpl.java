package pe.edu.cibertec.application.security.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.application.security.domain.User;
import pe.edu.cibertec.application.security.repository.UserRepository;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
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
}
