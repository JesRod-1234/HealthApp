package se.iths.HealthApp.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.HealthApp.entity.UserEntity;
import se.iths.HealthApp.repository.UserRepository;

@Service
public class HealthAppUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public HealthAppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null){
            throw new UsernameNotFoundException("can't find user with email: " + email);
        }
        return new HealthAppPrincipal(userEntity);
    }
}
