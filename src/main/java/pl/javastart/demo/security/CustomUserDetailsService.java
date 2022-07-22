package pl.javastart.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.javastart.demo.domain.ApplicationUser;
import pl.javastart.demo.repository.UserRepository;

@Service
class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found", username)));
    }

    private UserDetails createUserDetails(ApplicationUser user) {
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().getName())
                .build();
    }
}
