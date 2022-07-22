package pl.javastart.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.javastart.demo.domain.ApplicationUser;
import pl.javastart.demo.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void partialUpdate(ApplicationUser user) {
        ApplicationUser userEntity = userRepository.findById(user.getId()).orElseThrow();
        if (!user.getUsername().isEmpty()) {
            userEntity.setUsername(user.getUsername());
        }
        if (!user.getPassword().isEmpty()) {
            String newPassword = passwordEncoder.encode(user.getPassword());
            userEntity.setPassword(newPassword);
        }
        if (user.getRole() != null) {
            userEntity.setRole(user.getRole());
        }
    }

    public Optional<ApplicationUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<ApplicationUser> findAll() {
        return userRepository.findAll();
    }
}
