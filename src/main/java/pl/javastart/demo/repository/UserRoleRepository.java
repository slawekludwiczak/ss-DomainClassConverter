package pl.javastart.demo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.javastart.demo.domain.Role;

public interface UserRoleRepository extends CrudRepository<Role, Long> {
}
