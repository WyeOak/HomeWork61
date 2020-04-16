package lesson60.homework.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String s);
    User findByEmail(String email);
    User findByName(String name);
    User findUserById(String id);
}