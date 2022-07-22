package pl.javastart.demo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.javastart.demo.domain.ApplicationUser;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<ApplicationUser, Long> {
    List<ApplicationUser> findAll();
    Optional<ApplicationUser> findByUsername(String username);
}
